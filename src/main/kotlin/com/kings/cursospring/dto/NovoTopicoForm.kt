package com.kings.cursospring.dto

data class NovoTopicoForm(
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idUsuario: Long
)