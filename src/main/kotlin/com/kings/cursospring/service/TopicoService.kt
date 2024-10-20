package com.kings.cursospring.service

import com.kings.cursospring.dto.AtualizarTopicoDTO
import com.kings.cursospring.dto.NovoTopicoDTO
import com.kings.cursospring.dto.ResponseMessage
import com.kings.cursospring.dto.TopicoView
import com.kings.cursospring.exception.NotFoundException
import com.kings.cursospring.model.*
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val topicos: ArrayList<Topico> = ArrayList(),
    private val usuarioService: UsuarioService = UsuarioService(),
    private val cursoService: CursoService = CursoService()
) {
    fun getTopicos(): List<TopicoView> {
        val listView = topicos.map {
            val nomeUsuario = it.usuario?.nome ?: ""
            val nomeCurso = it.curso?.curso ?: ""
            TopicoView(
                it.id,
                it.titulo,
                it.mensagem ?: "",
                nomeUsuario,
                nomeCurso,
                it.statusTopico
            )
        }
        return listView
    }

    fun getTopicoID(id: Long): TopicoView {
        val topico = topicos.find { it.id == id } ?: throw NotFoundException("Tópico não encontrado.")
        val nomeUsuario = topico.usuario?.nome ?: ""
        val nomeCurso = topico.curso?.curso ?: ""
        return TopicoView(
            topico.id,
            topico.titulo,
            topico.mensagem ?: "",
            nomeUsuario,
            nomeCurso,
            topico.statusTopico
        )
    }

    fun postTopico(topicoDTO: NovoTopicoDTO): TopicoView {
        val topico = Topico(
            id = topicos.size + 1L,
            titulo = topicoDTO.titulo,
            mensagem = topicoDTO.mensagem,
            curso = cursoService.getCursoID(topicoDTO.idCurso) ?: throw NotFoundException("ID de curso não encontrado."),
            usuario = usuarioService.getUsuarioID(topicoDTO.idUsuario) ?: throw NotFoundException("ID de usuário não encontrado."),
            statusTopico = StatusTopico.NAO_RESPONDIDO
        )
        topicos.add(topico)

        val nomeUsuario = topico.usuario?.nome ?: ""
        val nomeCurso = topico.curso?.curso ?: ""
        return TopicoView(
            topico.id,
            topico.titulo,
            topico.mensagem ?: "",
            nomeUsuario,
            nomeCurso,
            topico.statusTopico
        )
    }

    fun putTopico(topicoDTO: AtualizarTopicoDTO, id: Long): ResponseMessage {
        val response = ResponseMessage("Tópico atualizado.")
        try {
            val index = topicos.indexOfFirst { it.id == id }
            if (index == -1) throw Exception("Tópico não encontrado.")
            val topico = topicos[index]
            topicos[index] = Topico(
                id = topico.id,
                titulo = topicoDTO.titulo ?: topico.titulo,
                mensagem = topicoDTO.mensagem ?: topico.mensagem,
                dataCriacao = topico.dataCriacao,
                curso = topico.curso,
                usuario = topico.usuario,
                statusTopico = topico.statusTopico,
                respostas = topico.respostas,
            )
        } catch (e: Exception) {
            response.mensagem = "Erro ao atualizar: ${e.message}"
        }
        return response
    }

    //    fun deleteTopico(id: Long): ResponseMessage {
//        val response = ResponseMessage("Tópico deletado.")
//        try {
//            val index = topicos.indexOfFirst { it.id == id }
//            if (index == -1) throw Exception("Tópico não encontrado.")
//            topicos.removeAt(index)
//        } catch (e: Exception) {
//            response.mensagem = "Erro ao deletar: ${e.message}"
//        }
//        return response
//    }
    fun deleteTopico(id: Long): ResponseMessage {
        val index = topicos.indexOfFirst { it.id == id }
        if (index == -1) throw NotFoundException("Tópico não encontrado.")
        topicos.removeAt(index)
        return ResponseMessage("Tópico deletado.")
    }

    fun deleteTopicoNoContent(id: Long) {
        val index = topicos.indexOfFirst { it.id == id }
        topicos.removeAt(index)
    }
}