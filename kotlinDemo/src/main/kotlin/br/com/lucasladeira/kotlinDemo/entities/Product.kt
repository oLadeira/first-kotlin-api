package br.com.lucasladeira.kotlinDemo.entities

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "tb_product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var name: String,
    var price: BigDecimal,
    var quantity: Int
) {
}