package com.kings.cursospring.model

import javax.persistence.*

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val nome: String,
    val email: String,
    val password: String
)
