package com.kings.cursospring.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val nome: String,
    val email: String,
    val password: String,

    @JsonIgnore
    @JoinColumn(name = "USUARIO_ROLE")
    @ManyToMany(fetch = FetchType.EAGER)
    val role: List<Role>
)
