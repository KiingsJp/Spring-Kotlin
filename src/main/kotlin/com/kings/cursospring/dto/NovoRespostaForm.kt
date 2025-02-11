package com.kings.cursospring.dto

data class NovoRespostaForm(
    val idUsuario: Long,
    val idTopico: Long,
    val mensagem: String,
    val solucao: Boolean
)