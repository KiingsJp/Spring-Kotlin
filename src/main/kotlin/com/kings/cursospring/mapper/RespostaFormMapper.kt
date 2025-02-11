package com.kings.cursospring.mapper

import com.kings.cursospring.dto.NovoRespostaForm
import com.kings.cursospring.exception.NotFoundException
import com.kings.cursospring.model.Resposta
import com.kings.cursospring.repository.TopicoRepository
import com.kings.cursospring.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class RespostaFormMapper(
    private val topicoRepository: TopicoRepository,
    private val usuarioService: UsuarioService
) : Mapper<NovoRespostaForm, Resposta> {

    override fun map(t: NovoRespostaForm): Resposta {
        return Resposta(
            autor = usuarioService.getUsuarioID(t.idUsuario),
            mensagem = t.mensagem,
            topico =  topicoRepository.findById(t.idTopico).orElseThrow{ NotFoundException("Tópico não encontrado") },
            solucao = t.solucao
        )
    }
}