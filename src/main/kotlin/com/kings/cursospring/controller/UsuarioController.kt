package com.kings.cursospring.controller

import com.kings.cursospring.model.Usuario
import com.kings.cursospring.service.UsuarioService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController(private val service: UsuarioService) {

    @GetMapping
    fun listarUsuarios(): List<Usuario> {
        return service.listar()
    }
}