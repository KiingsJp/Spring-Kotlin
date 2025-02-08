package com.kings.cursospring.model

object UsuarioTest {
    fun build() = Usuario(
        id = 1,
        nome = "Nome Usuario",
        email = "Email Usuario",
        password = "Password Usuario",
        role = listOf(Role(id = 1, nome = "Nome Role"))
    )
}