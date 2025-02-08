package com.kings.cursospring.model

object TopicoTest {
    fun build() = Topico(
        id = 1,
        titulo = "Titulo Topico",
        mensagem = "Mensagem Topico",
        curso = CursoTest.build(),
        usuario = UsuarioTest.build()
    )
}