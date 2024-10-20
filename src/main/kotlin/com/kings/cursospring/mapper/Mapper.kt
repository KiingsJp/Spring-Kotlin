package com.kings.cursospring.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}