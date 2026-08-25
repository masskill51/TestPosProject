package com.example.testpos.backend.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "sales")
class Sale(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "datetime", nullable = false)
    var datetime: String = "",

    @Column(nullable = false)
    var total: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    var cash: BigDecimal = BigDecimal.ZERO,

    @Column(name = "change_due", nullable = false)
    var changeDue: BigDecimal = BigDecimal.ZERO
)
