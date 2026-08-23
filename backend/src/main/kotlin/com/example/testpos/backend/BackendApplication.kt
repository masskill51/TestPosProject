package com.example.testpos.backend

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import com.example.testpos.backend.entity.InventoryItem
import com.example.testpos.backend.repository.InventoryItemRepository
import java.math.BigDecimal

@SpringBootApplication
class BackendApplication {
    @Bean
    fun init(repository: InventoryItemRepository) = CommandLineRunner {
        if (repository.count() == 0L) {
            repository.save(InventoryItem(name = "Milk", quantity = 10, price = BigDecimal("2.50")))
            repository.save(InventoryItem(name = "Bread", quantity = 3, price = BigDecimal("1.20")))
            repository.save(InventoryItem(name = "Eggs", quantity = 50, price = BigDecimal("0.15")))
        }
    }
}

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}

