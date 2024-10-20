package com.kings.cursospring.dto

import com.kings.cursospring.model.StatusTopico

data class TopicoView(
    val id: Long,
    val titulo: String,
    val mensagem: String,
    val nomeUsuario: String,
    val nomeCurso: String,
    val status: StatusTopico
)