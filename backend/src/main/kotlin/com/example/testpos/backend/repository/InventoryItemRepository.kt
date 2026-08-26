package com.example.testpos.backend.repository

import com.example.testpos.backend.entity.InventoryItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryItemRepository : JpaRepository<InventoryItem, Int>
