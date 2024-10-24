package com.kings.cursospring.model

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
data class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val nome: String,
) : GrantedAuthority {
    override fun getAuthority(): String = nome
}
