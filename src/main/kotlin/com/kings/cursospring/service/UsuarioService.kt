package com.kings.cursospring.service

import com.kings.cursospring.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val usuarios: ArrayList<Usuario> = ArrayList()
) {
    init {
        val user1 = Usuario(
            id = 1,
            nome = "Jp Reis",
            email = "kingsjp1207@gmail.com"
        )
        val user2 = Usuario(
            id = 2,
            nome = "Lana",
            email = "lana@gmail.com"
        )
        usuarios.add(user1)
        usuarios.add(user2)
    }

    fun getUsuarioID(id: Long): Usuario? {
        return usuarios.find { it.id == id }
    }
}