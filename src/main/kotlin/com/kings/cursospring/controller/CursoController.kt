package com.kings.cursospring.controller

import com.kings.cursospring.model.Curso
import com.kings.cursospring.service.CursoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cursos")
class CursoController(private val service: CursoService) {

    @GetMapping
    fun listar(): List<Curso> {
        return service.listar()
    }
}