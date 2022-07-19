package com.TransporTech.interfaces

import com.TransporTech.domain.Cliente
import com.TransporTech.domain.Produto
import com.TransporTech.domain.ProdutoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@Service
@RestController
@RequestMapping(path = ["/produtos"], produces = [MediaType.APPLICATION_JSON_VALUE])


class encomendaApi(

    val produtoRepository: ProdutoRepository

) {
    @GetMapping
    fun listarProdutos() = produtoRepository.findAll()

    @GetMapping("/{id}")
    fun findProdutos(@PathVariable("id") id: Long) =
        produtoRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

    @PostMapping
    fun criarProduto(@RequestBody produto: Produto) = produtoRepository.save(produto)

    @PutMapping("{id}")
    fun UpdateProdutoName(@PathVariable("id") id: Long, @RequestBody produto: Produto): Produto {
        val achaProduto = findProdutos(id)
        val copiaProduto = achaProduto.copy(
            dataCompra = produto.dataCompra

        )
        return produtoRepository.save(copiaProduto)

    }
    @DeleteMapping("/{id}")
    fun deleteProduto(@PathVariable("id") id: Long) =produtoRepository.deleteById(id)

}