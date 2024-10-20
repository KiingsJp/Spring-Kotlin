package com.kings.cursospring.repository

import com.kings.cursospring.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long>