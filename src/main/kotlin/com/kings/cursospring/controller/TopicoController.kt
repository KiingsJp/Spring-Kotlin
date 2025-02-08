package com.kings.cursospring.controller

import com.kings.cursospring.dto.AtualizacaoTopicoForm
import com.kings.cursospring.dto.NovoTopicoForm
import com.kings.cursospring.dto.TopicoView
import com.kings.cursospring.service.TopicoService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import javax.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@SecurityRequirement(name = "basicAuth")
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    @Cacheable("topicos") // ADICIONA O RESULTADO EM CACHE, A SEGUNDA CHAMADA DELE NAO VAI BUSCAR NO BANCO E SIM NO CACHE
    fun listar(
        @RequestParam(required = false) nomeCurso: String?,
        @PageableDefault(size = 5, sort = ["dataCriacao"], direction = Sort.Direction.DESC) paginacao: Pageable
    ): Page<TopicoView> {
        return service.listar(nomeCurso, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional // INDICA UMA TRANSACAO NO BANCO DE DADOS, UPDATE, DELETE, ETC
    @CacheEvict(value = ["topicos"], allEntries = true) // LIMPA TODOS OS REGISTROS DO CACHE TOPICOS
    fun cadastrar(
        @RequestBody form: NovoTopicoForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoView> {
        val topicoView = service.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun atualizar(@RequestBody form: AtualizacaoTopicoForm): ResponseEntity<TopicoView> {
        val topicoView = service.atualizar(form)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // A RESPOSTA DA REQUISIÇÃO VAI SER NO_CONTENT
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }

    @GetMapping("nao-respondido")
    fun topicosNaoRespondidos(): List<TopicoView> {
        return service.topicosNaoRespondidos()
    }
}