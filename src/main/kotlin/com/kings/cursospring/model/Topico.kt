package com.kings.cursospring.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topico(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val titulo: String,
    val mensagem: String?,
    val dataCriacao: LocalDateTime? = LocalDateTime.now(),

    @ManyToOne
    val curso: Curso?,

    @ManyToOne
    val usuario: Usuario?,

    @Enumerated(value = EnumType.STRING)
    val statusTopico: StatusTopico,

    @OneToMany(mappedBy = "idTopico")
    val respostas: List<Resposta>? = null
)
