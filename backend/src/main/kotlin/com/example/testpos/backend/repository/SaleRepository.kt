package com.example.testpos.backend.repository

import com.example.testpos.backend.entity.Sale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleRepository : JpaRepository<Sale, Int>
