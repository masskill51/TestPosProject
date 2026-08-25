package com.example.testpos.backend.repository

import com.example.testpos.backend.entity.PosUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PosUserRepository : JpaRepository<PosUser, Long> {
    fun findByUsername(username: String): PosUser?
}
