package com.kings.cursospring.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JWTUtil {

    private val expiration: Long = 60000L

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    fun generateToken(username: String): String {
        return Jwts.builder()
            .setSubject(username) // adiciona identificador de usuario
            .setExpiration(Date(System.currentTimeMillis() + expiration)) // adiciona tempo de expiração do token
            .signWith(SignatureAlgorithm.HS256, secret.toByteArray())
            .compact()
    }
}