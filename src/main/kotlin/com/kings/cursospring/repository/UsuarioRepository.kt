package com.kings.cursospring.repository

import com.kings.cursospring.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long>