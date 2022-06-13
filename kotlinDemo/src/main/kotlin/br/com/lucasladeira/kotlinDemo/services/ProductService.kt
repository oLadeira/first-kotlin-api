package br.com.lucasladeira.kotlinDemo.services

import br.com.lucasladeira.kotlinDemo.entities.Product
import java.math.BigDecimal

interface ProductService {

    //crud
    fun save(product: Product) : Product
    fun getAll() : List<Product>
    fun getById(id: Long) : Product
    fun update(id: Long, product: Product) : Product
    fun delete(id: Long)

    //regras de negócio
    fun calculateTotal(id: Long): BigDecimal
}