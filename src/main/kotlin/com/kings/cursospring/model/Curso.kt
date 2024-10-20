package com.kings.cursospring.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Curso(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val curso: String
)
