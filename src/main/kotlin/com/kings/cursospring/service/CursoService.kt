package com.kings.cursospring.service

import com.kings.cursospring.model.Curso
import org.springframework.stereotype.Service
import java.util.ArrayList

@Service
class CursoService(
    private val cursos: ArrayList<Curso> = ArrayList()
) {
    init {
        val curso1 = Curso(
            id = 1,
            curso = "Kotlin Spring"
        )
        val curso2 = Curso(
            id = 2,
            curso = "Java Spring"
        )
        cursos.add(curso1)
        cursos.add(curso2)
    }

    fun getCursoID(id: Long): Curso? {
        return cursos.find { it.id == id }
    }
}