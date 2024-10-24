package com.kings.cursospring.exception

import com.kings.cursospring.dto.ErrorView
import org.springframework.http.HttpStatus
import org.springframework.security.access.AccessDeniedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun notFoundException(exception: Exception): ErrorView {
        return ErrorView(
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.name,
            exception.message
        )
    }

    @ExceptionHandler(AccessDeniedException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun forbiddenException(exception: Exception): ErrorView {
        return ErrorView(
            HttpStatus.FORBIDDEN.value(),
            HttpStatus.FORBIDDEN.name,
            exception.message
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun erroInterno(exception: Exception): ErrorView {
        return ErrorView(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            HttpStatus.INTERNAL_SERVER_ERROR.name,
            exception.message
        )
    }
}