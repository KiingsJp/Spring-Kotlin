package com.kings.cursospring.mapper


import com.kings.cursospring.dto.NovoTopicoForm
import com.kings.cursospring.model.Topico
import com.kings.cursospring.service.CursoService
import com.kings.cursospring.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.getCursoID(t.idCurso),
            autor = usuarioService.getUsuarioID(t.idUsuario)
        )
    }
}