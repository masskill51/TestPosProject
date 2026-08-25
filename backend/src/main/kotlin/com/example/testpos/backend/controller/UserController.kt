package com.example.testpos.backend.controller

import com.example.testpos.backend.dto.UserDto
import com.example.testpos.backend.repository.PosUserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(private val userRepository: PosUserRepository) {

    @GetMapping
    fun getUsers(): List<UserDto> {
        return userRepository.findAll().map { user ->
            UserDto(
                id = (user.id ?: 0).toString(),
                username = user.username,
                name = user.username,
                role = user.role
            )
        }
    }
}
