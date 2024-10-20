package com.kings.cursospring.model

import javax.persistence.*

@Entity
data class Curso(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val curso: String
)
