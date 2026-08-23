package com.example.testpos.backend.dto

import java.math.BigDecimal

data class SalesReportDto(
    val totalSales: BigDecimal,
    val itemsSold: Int,
    val reportDate: String
)
