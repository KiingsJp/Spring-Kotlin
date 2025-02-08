package com.kings.cursospring.service

import com.kings.cursospring.dto.AtualizacaoTopicoForm
import com.kings.cursospring.dto.NovoTopicoForm
import com.kings.cursospring.dto.TopicoView
import com.kings.cursospring.exception.NotFoundException
import com.kings.cursospring.mapper.TopicoFormMapper
import com.kings.cursospring.mapper.TopicoViewMapper
import com.kings.cursospring.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.persistence.EntityManager

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val entityManager: EntityManager
) {
    private val notFoundMessage: String = "Topico nao encontrado!"

    fun listar(nomeCurso: String?, paginacao: Pageable): Page<TopicoView> {
        val topicos = if (nomeCurso == null) repository.findAll(paginacao) else repository.findByCursoNome(nomeCurso, paginacao)
        return topicos.map { t -> topicoViewMapper.map(t) }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findById(form.id).orElseThrow { NotFoundException(notFoundMessage) }
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        topico.dataAlteracao = LocalDate.now()
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun topicosNaoRespondidos(): List<TopicoView>{
        val topicos = repository.topicosNaoRespondidos()
        return topicos.map { t -> topicoViewMapper.map(t) }
    }
}