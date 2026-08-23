package com.example.testpos.backend.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "sales")
class Sale(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val quantity: Int,

    @Column(nullable = false)
    val totalPrice: BigDecimal,

    @Column(nullable = false)
    val saleDate: LocalDateTime = LocalDateTime.now()
)
