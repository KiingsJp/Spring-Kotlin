package com.kings.cursospring.dto

data class NovoTopicoDTO(
    val titulo: String,
    val mensagem: String,
    val idUsuario: Long,
    val idCurso: Long
)