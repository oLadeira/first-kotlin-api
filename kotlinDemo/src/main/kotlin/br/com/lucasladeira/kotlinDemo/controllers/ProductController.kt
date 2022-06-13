package br.com.lucasladeira.kotlinDemo.controllers

import br.com.lucasladeira.kotlinDemo.entities.Product
import br.com.lucasladeira.kotlinDemo.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/products")
class ProductController{

    @Autowired
    lateinit var productService: ProductService

    @PostMapping
    fun save(@RequestBody product: Product): ResponseEntity<Product>{
        return ResponseEntity.status(HttpStatus.OK).body(productService.save(product))
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<Product>>{
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Product>{
        return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product): ResponseEntity<Product>{
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(id, product))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void>{
        productService.delete(id)
        return ResponseEntity.status(HttpStatus.OK).build()
    }

    @GetMapping("/calculateTotal/{id}")
    fun calculateTotal(@PathVariable id: Long): ResponseEntity<BigDecimal>{
        return ResponseEntity.status(HttpStatus.OK).body(productService.calculateTotal(id))
    }
}