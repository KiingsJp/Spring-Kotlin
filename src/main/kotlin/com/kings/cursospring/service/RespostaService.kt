package com.kings.cursospring.service

import com.kings.cursospring.dto.NovoRespostaForm
import com.kings.cursospring.mapper.RespostaFormMapper
import com.kings.cursospring.repository.RespostaRepository
import org.springframework.stereotype.Service

@Service
class RespostaService(
    private val respostaRepositoru: RespostaRepository,
    private val respostaFormMapper: RespostaFormMapper,
    private val emailService: EmailService
) {
    fun salvar(form: NovoRespostaForm) {
        val resposta = respostaFormMapper.map(form)
        respostaRepositoru.save(resposta)
        val email = resposta.topico.usuario.email
        emailService.notificar(email)
    }
}