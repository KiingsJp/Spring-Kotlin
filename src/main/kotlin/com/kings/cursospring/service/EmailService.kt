package com.kings.cursospring.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(
    private val javaMailSender: JavaMailSender
) {
    fun notificar(email: String) {
        val message = SimpleMailMessage()
        message.setSubject("Titulo teste")
        message.setText("corpo do email")
        message.setTo(email)

        javaMailSender.send(message)
    }
}