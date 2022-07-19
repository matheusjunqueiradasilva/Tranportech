package com.TransporTech.interfaces

import com.TransporTech.domain.Encomenda
import com.TransporTech.domain.EncomendaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import javax.sound.midi.Patch

@Service
@RestController
@RequestMapping(path = ["/produtos"], produces = [MediaType.APPLICATION_JSON_VALUE])


class encomendaApi(

    val encomendaRepository: EncomendaRepository

) {
    @GetMapping
    fun listarEncomendas() = encomendaRepository.findAll()

    @GetMapping("/{id}")
    fun findEncomendas(@PathVariable("id") id: Long) =
        encomendaRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

    @PostMapping
    fun criarEncomendas(@RequestBody encomenda: Encomenda) = encomendaRepository.save(encomenda)

    @PutMapping("{id}")
    fun UpdateEncomendaName(@PathVariable("id") id: Long, @RequestBody encomenda: Encomenda): Encomenda {
        val achaEncomenda = findEncomendas(id)
        val copiaEncomenda = achaEncomenda.copy(
            dataCompra = encomenda.dataCompra ?: achaEncomenda.dataCompra,
            nome = encomenda.nome
        )
        return encomendaRepository.save(copiaEncomenda)

    }
    @DeleteMapping("/{id}")
    fun deleteEncomenda(@PathVariable("id") id: Long) =encomendaRepository.deleteById(id)

}