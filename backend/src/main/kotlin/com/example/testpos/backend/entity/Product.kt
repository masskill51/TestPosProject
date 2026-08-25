package com.example.testpos.backend.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "products")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var price: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    var stock: Int = 0,

    @Column(unique = true)
    var barcode: String? = null
)
