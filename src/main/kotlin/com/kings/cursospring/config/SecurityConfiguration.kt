package com.kings.cursospring.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
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
    private val userDetailsService: UserDetailsService,
//    private val jwtUtil: JWTUtil
): WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.
        csrf()?.disable()?.
        authorizeRequests()?.
        antMatchers(HttpMethod.POST, "/**")?.permitAll()?.
        antMatchers(HttpMethod.GET, "/swagger-ui/*")?.permitAll()?.
        antMatchers(HttpMethod.GET, "/v3/api-docs/**")?.permitAll()?.
        anyRequest()?.
        authenticated()?.
        and()
        http?.httpBasic()
        http?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // define a politica de sessão, nesta deve ser passado todas as informações para o login
//      ?.formLogin()?.disable()?. // disativa o login padrao do spring security

        //  Adicionamos os filtros de JWT
//        http?.addFilterBefore(JWTLoginFilter(authManager = authenticationManager(), jwtUtil = jwtUtil), UsernamePasswordAuthenticationFilter::class.java)
//        http?.addFilterBefore(JWTAuthenticationFilter(jwtUtil = jwtUtil), UsernamePasswordAuthenticationFilter::class.java)
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userDetailsService)?.passwordEncoder(bCryptPasswordEncoder())
    }
}