package com.kings.cursospring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class CursoSpringApplication

fun main(args: Array<String>) {
	runApplication<CursoSpringApplication>(*args)
}
