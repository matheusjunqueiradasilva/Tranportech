package com.TransporTech.domain

import org.springframework.data.jpa.repository.JpaRepository
interface MotoristasRepository : JpaRepository<Motoristas,Long>
interface EncomendaRepository : JpaRepository<Encomenda,Long>
interface ClienteRepository : JpaRepository<Cliente,Long>

