package com.kings.cursospring.service

import com.kings.cursospring.exception.NotFoundException
import com.kings.cursospring.mapper.TopicoFormMapper
import com.kings.cursospring.mapper.TopicoViewMapper
import com.kings.cursospring.model.TopicoTest
import com.kings.cursospring.model.TopicoViewTest
import com.kings.cursospring.repository.TopicoRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*
import kotlin.test.Test

class TopicoServiceTest {

    private val topico = PageImpl(listOf(TopicoTest.build()))

    private val paginacao: Pageable = mockk()

    private val topicoRepository: TopicoRepository = mockk {
        every { findByCursoNome(any(), any()) } returns topico
        every { findAll(paginacao) } returns topico
    }

    private val topicoViewMapper: TopicoViewMapper = mockk {
        every { map(any()) } returns TopicoViewTest.build()
    }
    private val topicoFormMapper: TopicoFormMapper = mockk()

    val topicoService: TopicoService = TopicoService(topicoRepository, topicoViewMapper, topicoFormMapper)

    @Test
    fun `deve listar topicos a partir do nome do curso` () {

        // Chamar a ação que quero testar
        topicoService.listar("Curso Teste", paginacao)

        // Verifica se o metodo findByCursoNome foi chamado exatamentoe 1 vez
        verify(exactly = 1) { topicoRepository.findByCursoNome(any(), any()) }

        // Verifica se o metodo de findAll nao foi chamado nenhuma vez - Nao deve ser chaamdo pois passamos um curso
        verify(exactly = 0) { topicoRepository.findAll(paginacao) }

        // TopicoViewMapper tambem deve ser chamado 1 vez
        verify(exactly = 1) { topicoViewMapper.map(any()) }
    }

    @Test
    fun `deve listar todos os cursos se nao passar nenhum nome`() {
        topicoService.listar(null, paginacao)

        verify(exactly = 1) { topicoRepository.findAll(paginacao) }
        verify(exactly = 0) { topicoRepository.findByCursoNome(any(), any()) }
        verify(exactly = 1) { topicoViewMapper.map(any()) }
    }

    @Test
    fun `deve listar not found exception quando nao for encontrado o topico passado`() {
        every { topicoRepository.findById(any()) } returns Optional.empty() // Toda chamada do metodo nao vai encontrar resultado

        val actual = assertThrows<NotFoundException> {
            topicoService.buscarPorId(1)
        }

        assertThat(actual.message).isEqualTo("Topico nao encontrado!")
    }

}