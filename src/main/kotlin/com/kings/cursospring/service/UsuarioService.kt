package com.kings.cursospring.service

import com.kings.cursospring.exception.NotFoundException
import com.kings.cursospring.model.Usuario
import com.kings.cursospring.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
) : UserDetailsService {
    fun getUsuarioID(id: Long): Usuario {
        return repository.getOne(id)
    }

    fun listar(): List<Usuario>{
        return repository.findAll()
    }

    override fun loadUserByUsername(email: String?): UserDetails {
        val user = repository.findByEmail(email) ?: throw NotFoundException("Falha na autenticação: Usuário não encontrado")
        return UserDetail(user)
    }
}