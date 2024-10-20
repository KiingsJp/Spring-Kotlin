package com.kings.cursospring.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Resposta(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    val autor: Usuario,

    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val mensagem: String,
    val idTopico: Long,
    val solucao: Boolean
)
