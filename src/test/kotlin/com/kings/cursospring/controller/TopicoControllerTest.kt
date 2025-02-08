package com.kings.cursospring.controller

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TopicoControllerTest {
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    companion object {
        private const val URI = "/topicos/"
        private const val URI_WITH_PARAM = URI.plus("%s")
    }

    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .apply<DefaultMockMvcBuilder?>(
                SecurityMockMvcConfigurers
                    .springSecurity()).build()
    }

    @Test
    fun `deve retornar erro sem autenticacao`() {
        mockMvc.get(URI).andExpect { status { is4xxClientError() } }
    }

    @Test
    fun `deve fazer a autenticacao e retornar OK`() {
        mockMvc.get(URI) {
            headers { this.setBasicAuth("jpreis@email.com", "kings") }
        }.andExpect { status { is2xxSuccessful() } }
    }

    @Test
    fun `deve retornar codigo 200 quando chamar topicos por id e usuario estiver autenticado`() {
        mockMvc.get(URI_WITH_PARAM.format("1")) {
            headers { this.setBasicAuth("jpreis@email.com", "kings") }
        }.andExpect { status { isOk() } }
    }
}