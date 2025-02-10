package com.kings.cursospring.model

import java.io.Serializable
import javax.persistence.*

@Entity
data class Curso(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val nome: String,
    val categoria: String
) : Serializable
