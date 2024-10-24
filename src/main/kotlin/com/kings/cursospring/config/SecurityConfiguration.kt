package com.kings.cursospring.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val userDetailsService: UserDetailsService
): WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http?.
        authorizeRequests()?. // cuide da autorização das requisições
        anyRequest()?. // de qualquer requisição
        authenticated()?. // precisa ser autenticada
        and()?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)?. // define a politica de sessão, nesta deve ser passado todas as informações para o login
        and()?.formLogin()?.disable()?. // disativa o login padrao do spring security
        httpBasic() // utilize a autenticação httpBasic
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.
        userDetailsService(userDetailsService)?.
        passwordEncoder(bCryptPasswordEncoder())
    }
}