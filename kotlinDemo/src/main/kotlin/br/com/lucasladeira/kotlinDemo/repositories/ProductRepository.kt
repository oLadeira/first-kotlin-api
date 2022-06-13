package br.com.lucasladeira.kotlinDemo.repositories

import br.com.lucasladeira.kotlinDemo.entities.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
}