package com.example.testpos.backend.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "products")
class InventoryItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    val name: String = "",

    @Column(name = "stock", nullable = false)
    val quantity: Int = 0,

    @Column(nullable = false)
    val price: BigDecimal = BigDecimal.ZERO,
    
    @Column(nullable = true)
    val barcode: String? = null
)
