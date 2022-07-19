package com.TransporTech.domain

import org.springframework.data.jpa.repository.JpaRepository

interface MotoristasRepository : JpaRepository<Motoristas,Long>
interface ProdutoRepository : JpaRepository<Produto,Long>
interface ClienteRepository : JpaRepository<Cliente,Long>

