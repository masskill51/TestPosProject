package com.example.testpos.backend.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "sale_items")
class SaleItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "sale_id", nullable = false)
    var saleId: Long = 0,

    @Column(name = "product_name", nullable = false)
    var productName: String = "",

    @Column(nullable = false)
    var price: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    var quantity: Int = 0
)
