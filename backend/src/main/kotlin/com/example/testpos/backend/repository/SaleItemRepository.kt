package com.example.testpos.backend.repository

import com.example.testpos.backend.entity.SaleItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleItemRepository : JpaRepository<SaleItem, Int>
