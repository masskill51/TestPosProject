package com.example.testpos.backend.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class PosUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false, unique = true)
    var username: String = "",

    @Column(nullable = false)
    var password: String = "",

    @Column(nullable = false)
    var role: String = ""
)
