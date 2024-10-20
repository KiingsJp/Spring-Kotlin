package com.kings.cursospring.controller

import com.kings.cursospring.dto.AtualizarTopicoDTO
import com.kings.cursospring.dto.NovoTopicoDTO
import com.kings.cursospring.dto.ResponseMessage
import com.kings.cursospring.dto.TopicoView
import com.kings.cursospring.service.TopicoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listarTopicos(): List<TopicoView> {
        return service.getTopicos()
    }

    @GetMapping("/{id}")
    fun listarTopicoId(@PathVariable id: Long) : TopicoView {
        return service.getTopicoID(id)
    }

    @PostMapping()
    fun cadastrar(@RequestBody topico: NovoTopicoDTO, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoView> {
        val topicoView = service.postTopico(topico)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping("/{id}")
    fun atualizar(@RequestBody topico: AtualizarTopicoDTO, @PathVariable id: Long): ResponseMessage {
        return service.putTopico(topico, id)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseMessage {
        return service.deleteTopico(id)
    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun deletar(@PathVariable id: Long) {
//        service.deleteTopicoNoContent(id)
//    }
}