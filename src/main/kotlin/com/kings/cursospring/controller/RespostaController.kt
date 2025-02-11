package com.kings.cursospring.controller

import com.kings.cursospring.dto.NovoRespostaForm
import com.kings.cursospring.service.RespostaService
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional

@RestController
@RequestMapping("/respostas")
class RespostaController(private val respostaService: RespostaService) {

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody respostaForm: NovoRespostaForm) {
        respostaService.salvar(respostaForm)
    }

}