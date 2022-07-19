package com.TransporTech.domain



import java.time.LocalDate
import java.util.concurrent.ThreadLocalRandom
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Motoristas(
    @Id
    @GeneratedValue  //permite que o post seja feito corretamente
    var id: Long? = null,
    val nome: String?,
    val DataAdmissao: LocalDate? = LocalDate.now(),
    val cnh: Long? =ThreadLocalRandom.current().nextLong(),
    val kmPercorrido: Int? = ThreadLocalRandom.current().nextInt(),
    val ativo: Boolean? = ThreadLocalRandom.current().nextBoolean()

    )
@Entity
data class Produto(
    @Id
    @GeneratedValue
    var id: Long? = null,
    val nome: String?,
    val dataCompra: LocalDate? = LocalDate.now(),
    val dataEntrega: LocalDate? = dataCompra?.plusDays(7),
    val NumerodaEncomenda: Long?= ThreadLocalRandom.current().nextLong(),
    val Quantidade:Int? = ThreadLocalRandom.current().nextInt()


    )
@Entity
data class Cliente(
    @Id
    @GeneratedValue
    var id: Long? = null,
    val nome: String?,
    val CPF: Long? = ThreadLocalRandom.current().nextLong(),
    val dataCadastro:LocalDate? = LocalDate.now().minusWeeks(7),
    val endereco: String? = ThreadLocalRandom.current().toString(),
    val ativo: Boolean? = ThreadLocalRandom.current().nextBoolean()

)
