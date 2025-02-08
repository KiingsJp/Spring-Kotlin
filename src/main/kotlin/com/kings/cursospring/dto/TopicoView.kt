package com.kings.cursospring.dto

import com.kings.cursospring.model.Curso
import com.kings.cursospring.model.StatusTopico
import com.kings.cursospring.model.Usuario
import java.time.LocalDate
import java.time.LocalDateTime

data class TopicoView(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime,
    val usuario: Usuario,
    val curso: Curso,
    val dataAlteracao: LocalDate?

)