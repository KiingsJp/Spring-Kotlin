package com.kings.cursospring.dto

data class ErrorView(
    val status: Int,
    val error: String,
    val message: String?
)
