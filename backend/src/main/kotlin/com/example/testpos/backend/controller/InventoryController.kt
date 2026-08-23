package com.example.testpos.backend.controller

import com.example.testpos.backend.entity.InventoryItem
import com.example.testpos.backend.repository.InventoryItemRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/inventory")
class InventoryController(private val repository: InventoryItemRepository) {

    @GetMapping
    fun getAllItems(): List<InventoryItem> {
        return repository.findAll()
    }
}
