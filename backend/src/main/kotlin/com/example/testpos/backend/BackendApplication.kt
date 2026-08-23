package com.example.testpos.backend

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import com.example.testpos.backend.entity.InventoryItem
import com.example.testpos.backend.entity.Sale
import com.example.testpos.backend.repository.InventoryItemRepository
import com.example.testpos.backend.repository.SaleRepository
import java.math.BigDecimal
import java.time.LocalDateTime

@SpringBootApplication
class BackendApplication {
    @Bean
    fun init(
        inventoryRepository: InventoryItemRepository,
        saleRepository: SaleRepository
    ) = CommandLineRunner {
        if (inventoryRepository.count() == 0L) {
            inventoryRepository.save(InventoryItem(name = "Milk", quantity = 10, price = BigDecimal("2.50")))
            inventoryRepository.save(InventoryItem(name = "Bread", quantity = 3, price = BigDecimal("1.20")))
            inventoryRepository.save(InventoryItem(name = "Eggs", quantity = 50, price = BigDecimal("0.15")))
        }

        if (saleRepository.count() == 0L) {
            saleRepository.save(Sale(quantity = 2, totalPrice = BigDecimal("5.00"), saleDate = LocalDateTime.now()))
            saleRepository.save(Sale(quantity = 1, totalPrice = BigDecimal("1.20"), saleDate = LocalDateTime.now()))
        }
    }
}

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}

