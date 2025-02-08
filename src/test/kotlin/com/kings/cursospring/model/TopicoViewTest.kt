package com.kings.cursospring.model

import com.kings.cursospring.dto.TopicoView
import java.time.LocalDate
import java.time.LocalDateTime

object TopicoViewTest {
    fun build() = TopicoView(
        id = 1L,
        titulo = "Titulo TopicoView",
        mensagem = "Mensagem TopicoView",
        status = StatusTopico.SOLUCIONADO,
        dataCriacao = LocalDateTime.now(),
        usuario = UsuarioTest.build(),
        curso = CursoTest.build(),
        dataAlteracao = LocalDate.now()
    )
}