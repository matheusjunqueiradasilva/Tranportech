package com.TransporTech.interfaces

import com.TransporTech.domain.ClienteRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RestController
import com.TransporTech.domain.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.web.server.ResponseStatusException

@Service
@RestController
@RequestMapping(path = ["/clientes"], produces = [MediaType.APPLICATION_JSON_VALUE])


class clienteApi(

    val clienteRepository: ClienteRepository

) {
    @GetMapping
    fun listarClientes() = clienteRepository.findAll()

    @GetMapping("/{id}")
    fun findCliente(@PathVariable("id") id: Long) =
        clienteRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

    @PostMapping
    fun criarCliente(@RequestBody cliente: Cliente) = clienteRepository.save(cliente)

    @PutMapping("{id}")
    fun UpdateClienteName(@PathVariable("id") id: Long, @RequestBody cliente: Cliente): Cliente {
        val achaCliente = findCliente(id)
        val copiaCliente = achaCliente.copy(
            dataCadastro =cliente.dataCadastro ?: achaCliente.dataCadastro,
            nome =cliente.nome
        )
        return clienteRepository.save(copiaCliente)

    }
    @DeleteMapping("/{id}")
    fun deleteCliente(@PathVariable("id") id: Long) =clienteRepository.deleteById(id)

}