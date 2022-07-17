package com.TransporTech.interfaces

import com.TransporTech.domain.Motoristas
import com.TransporTech.domain.MotoristasRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import javax.persistence.Id

@Service
@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE]) //retorna um json da funcao
class MotoristasApi (

    val motoristasRepository: MotoristasRepository // referencia a motorista rpository

) {
    @GetMapping("/motoristas") //get e lista todos os motoristas
        fun listarMotoristas() = motoristasRepository.findAll()

    @GetMapping("/motoristas/{id}")
        fun findMotorista(@PathVariable("id") Id:Long) =
            motoristasRepository.findById(Id).get()

    @PostMapping("/motoristas") // função que implementa o método post
    fun criarMotorista(@RequestBody motoristas: Motoristas)= motoristasRepository.save(motoristas)


    @PutMapping("/motoristas/{id}")
        fun fullUpdateMotorista(@PathVariable("id") id: Long, @RequestBody motoristas: Motoristas): Motoristas {
            val achaMotorista = findMotorista(id)
            val copiaMotorista = achaMotorista.copy(
                DataAdmissao = motoristas.DataAdmissao?:achaMotorista.DataAdmissao,
                nome = motoristas.nome


            )
        return motoristasRepository.save(copiaMotorista)
        }

    @DeleteMapping("/motoristas/{id}")
        fun deleteMotorista(@PathVariable("id") id: Long) = motoristasRepository.deleteById(id)


}

