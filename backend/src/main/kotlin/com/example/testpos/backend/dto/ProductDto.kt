package com.example.testpos.backend.dto

data class ProductDto(
    val id: String,
    val name: String,
    val category: String = "General",
    val price: Double,
    val stockQuantity: Int,
    val threshold: Int = 5,
    val barcode: String?
)
