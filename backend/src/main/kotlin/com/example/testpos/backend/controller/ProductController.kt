package com.example.testpos.backend.controller

import com.example.testpos.backend.dto.ProductDto
import com.example.testpos.backend.repository.ProductRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController(private val productRepository: ProductRepository) {

    @GetMapping
    fun getProducts(): List<ProductDto> {
        return productRepository.findAll().map { product ->
            ProductDto(
                id = (product.id ?: 0).toString(),
                name = product.name,
                category = "General",
                price = product.price.toDouble(),
                stockQuantity = product.stock,
                threshold = 5,
                barcode = product.barcode
            )
        }
    }
}
