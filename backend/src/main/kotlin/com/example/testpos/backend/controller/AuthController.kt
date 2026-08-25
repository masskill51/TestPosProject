package com.example.testpos.backend.controller

import com.example.testpos.backend.dto.AuthResponse
import com.example.testpos.backend.dto.LoginRequest
import com.example.testpos.backend.repository.PosUserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(private val userRepository: PosUserRepository) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> {
        val user = userRepository.findByUsername(request.username)
        
        return if (user != null && user.password == request.password) {
            ResponseEntity.ok(
                AuthResponse(
                    userId = (user.id ?: 0).toString(),
                    username = user.username,
                    role = user.role,
                    token = "fake-jwt-token" // Placeholder
                )
            )
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(mapOf("error" to "Invalid username or password"))
        }
    }
}
