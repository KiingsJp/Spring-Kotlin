package com.kings.cursospring.service

import com.kings.cursospring.model.Usuario
import com.kings.cursospring.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
) {
    fun getUsuarioID(id: Long): Usuario {
        return repository.getOne(id)
    }

    fun listar(): List<Usuario>{
        return repository.findAll()
    }
}