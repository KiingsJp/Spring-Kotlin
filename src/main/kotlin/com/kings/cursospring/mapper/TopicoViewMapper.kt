package com.kings.cursospring.mapper

import com.kings.cursospring.dto.TopicoView
import com.kings.cursospring.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoView> {

    override fun map(t: Topico): TopicoView {
        return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status,
            usuario = t.autor
        )
    }
}