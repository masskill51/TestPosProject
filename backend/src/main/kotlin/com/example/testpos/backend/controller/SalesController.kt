package com.example.testpos.backend.controller

import com.example.testpos.backend.dto.CashierReportDto
import com.example.testpos.backend.dto.CategorySummaryDto
import com.example.testpos.backend.dto.SaleSummaryDto
import com.example.testpos.backend.dto.SalesReportDto
import com.example.testpos.backend.repository.SaleItemRepository
import com.example.testpos.backend.repository.SaleRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.time.LocalDate
import java.time.ZoneId

@RestController
@RequestMapping("/api/sales")
class SalesController(
    private val saleRepository: SaleRepository,
    private val saleItemRepository: SaleItemRepository
) {

    @GetMapping("/report")
    fun getSalesReport(): SalesReportDto {
        val today = LocalDate.now(ZoneId.of("Asia/Manila")).toString()
        val salesToday = saleRepository.findAll().filter { it.datetime.startsWith(today) }
        val saleIds = salesToday.mapNotNull { it.id }.toSet()
        val totalAmount = salesToday.map { it.total }.fold(BigDecimal.ZERO, BigDecimal::add)
        val totalItems = saleItemRepository.findAll()
            .filter { it.saleId in saleIds }
            .sumOf { it.quantity }

        return SalesReportDto(
            totalSales = totalAmount,
            itemsSold = totalItems,
            reportDate = today
        )
    }

    @GetMapping("/summary")
    fun getSaleSummary(): SaleSummaryDto {
        val sales = saleRepository.findAll()
        val items = saleItemRepository.findAll()
        val totalRevenue = sales.map { it.total }.fold(BigDecimal.ZERO, BigDecimal::add).toDouble()
        val topCategories = items
            .groupBy { it.productName }
            .map { (name, lines) ->
                CategorySummaryDto(
                    category = name,
                    revenue = lines.sumOf { it.price.toDouble() * it.quantity }
                )
            }
            .sortedByDescending { it.revenue }
            .take(5)

        return SaleSummaryDto(
            totalRevenue = totalRevenue,
            totalTransactions = sales.size,
            topCategories = topCategories
        )
    }

    @GetMapping("/reports/cashier")
    fun getCashierReports(): List<CashierReportDto> {
        val sales = saleRepository.findAll()
        val total = sales.map { it.total }.fold(BigDecimal.ZERO, BigDecimal::add).toDouble()
        return listOf(
            CashierReportDto(
                cashierName = "Madam POS",
                totalSales = total,
                transactionCount = sales.size
            )
        )
    }
}
