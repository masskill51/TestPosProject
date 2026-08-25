package com.example.testpos.backend.dto

data class LoginRequest(
    val username: String,
    val password: String
)

data class AuthResponse(
    val userId: String,
    val username: String,
    val role: String,
    val token: String // Placeholder for now
)
