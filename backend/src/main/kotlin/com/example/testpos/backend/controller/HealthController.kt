package com.example.testpos.backend.controller

import com.example.testpos.backend.repository.PosUserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController(private val userRepository: PosUserRepository) {
    @GetMapping("/api/health")
    fun health(): Map<String, String> {
        return try {
            val count = userRepository.count()
            mapOf("status" to "UP", "database" to "Connected", "userCount" to count.toString())
        } catch (e: Exception) {
            mapOf("status" to "DOWN", "database" to "Error: ${e.message}")
        }
    }
}
