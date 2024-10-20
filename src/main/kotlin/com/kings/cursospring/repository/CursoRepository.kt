package com.kings.cursospring.repository

import com.kings.cursospring.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {
}