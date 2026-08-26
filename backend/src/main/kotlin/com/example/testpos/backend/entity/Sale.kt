package com.example.testpos.backend.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "sales")
class Sale(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "datetime", nullable = false)
    var datetime: LocalDateTime = LocalDateTime.now(),

    @Column(name = "total", nullable = false)
    var total: BigDecimal = BigDecimal.ZERO,

    @Column(name = "cash", nullable = false)
    var cash: BigDecimal = BigDecimal.ZERO,

    @Column(name = "change_due", nullable = false)
    var changeDue: BigDecimal = BigDecimal.ZERO
)
