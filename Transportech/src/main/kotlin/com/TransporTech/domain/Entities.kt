package com.TransporTech.domain

import java.time.LocalDate
import java.util.Random
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Motoristas(
    @Id
    @GeneratedValue  //permite que o post seja feito corretamente
    var id: Long? = null,
    val nome: String?,
    val DataAdmissao: LocalDate?,
    val cnh: Int? =null,




    )
