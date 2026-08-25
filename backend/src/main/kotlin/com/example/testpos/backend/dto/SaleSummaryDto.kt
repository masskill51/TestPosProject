package com.example.testpos.backend.dto

data class SaleSummaryDto(
    val totalRevenue: Double,
    val totalTransactions: Int,
    val topCategories: List<CategorySummaryDto>
)

data class CategorySummaryDto(
    val category: String,
    val revenue: Double
)

data class CashierReportDto(
    val cashierName: String,
    val totalSales: Double,
    val transactionCount: Int
)

data class UserDto(
    val id: String,
    val username: String,
    val name: String,
    val role: String
)
