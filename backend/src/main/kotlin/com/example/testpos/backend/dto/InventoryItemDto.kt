package com.example.testpos.backend.dto

import java.math.BigDecimal

data class InventoryItemDto(
    val id: Long,
    val name: String,
    val quantity: Int,
    val price: BigDecimal,
    val minStockLevel: Int = 5,
    val barcode: String?
)
