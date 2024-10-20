package com.kings.cursospring.service

import com.kings.cursospring.model.Curso
import com.kings.cursospring.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(
    private val repository: CursoRepository,
) {
    fun getCursoID(id: Long): Curso {
        return repository.getOne(id)
    }

    fun listar(): List<Curso> {
        return repository.findAll()
    }
}