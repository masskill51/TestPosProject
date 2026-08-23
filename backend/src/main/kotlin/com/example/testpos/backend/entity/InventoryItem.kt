package com.example.testpos.backend.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "inventory_items")
class InventoryItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val quantity: Int,

    @Column(nullable = false)
    val price: BigDecimal,

    @Column(nullable = false)
    val minStockLevel: Int = 5
)
