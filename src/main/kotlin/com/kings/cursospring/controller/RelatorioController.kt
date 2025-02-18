package com.kings.cursospring.controller

import com.kings.cursospring.service.TopicoService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/relatorios")
class RelatorioController(
    private val topicoService: TopicoService
) {

    @GetMapping
    fun relatorio(model: Model) : String{
        model.addAttribute("topicosNaoRespondidos", topicoService.topicosNaoRespondidos())
//        model.addAttribute("topicosNaoRespondido", ArrayList<TopicoView>())
        return "relatorio"
    }
}