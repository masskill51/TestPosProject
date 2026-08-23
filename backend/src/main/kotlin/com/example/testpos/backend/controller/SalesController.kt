package com.example.testpos.backend.controller

import com.example.testpos.backend.dto.SalesReportDto
import com.example.testpos.backend.repository.SaleRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@RestController
@RequestMapping("/api/sales")
class SalesController(private val saleRepository: SaleRepository) {

    @GetMapping("/report")
    fun getSalesReport(): SalesReportDto {
        val todayStart = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT)
        val salesToday = saleRepository.findAllBySaleDateAfter(todayStart)

        val totalAmount = salesToday.map { it.totalPrice }.fold(BigDecimal.ZERO, BigDecimal::add)
        val totalItems = salesToday.sumOf { it.quantity }

        return SalesReportDto(
            totalSales = totalAmount,
            itemsSold = totalItems,
            reportDate = LocalDate.now().toString()
        )
    }
}
