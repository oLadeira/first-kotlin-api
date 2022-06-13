package br.com.lucasladeira.kotlinDemo.services

import br.com.lucasladeira.kotlinDemo.entities.Product
import br.com.lucasladeira.kotlinDemo.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import javax.persistence.EntityNotFoundException

@Service
class ProductServiceImpl: ProductService {

    @Autowired
    lateinit var productRepository: ProductRepository

    override fun save(product: Product): Product {
        return productRepository.save(product)
    }

    override fun getAll(): List<Product> {
        return productRepository.findAll()
    }

    override fun getById(id: Long): Product {
        return productRepository
            .findById(id)
            .orElseThrow { EntityNotFoundException("Product not found!") }
    }

    override fun update(id: Long, updatedProduct: Product): Product {
        var productDB: Product = productRepository
            .findById(id)
            .orElseThrow{ EntityNotFoundException("Product not found!") }

        return productRepository.save(updatedProduct.copy(productDB.id))
    }

    override fun delete(id: Long) {
        productRepository.findById(id).orElseThrow{ EntityNotFoundException("Product not found!") }
        return productRepository.deleteById(id)
    }

    override fun calculateTotal(id: Long): BigDecimal {
        val product: Product = productRepository.findById(id).orElseThrow { EntityNotFoundException("Product not found!") }

        return product.price.multiply(product.quantity.toBigDecimal())
    }

}