package com.kings.cursospring.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

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
