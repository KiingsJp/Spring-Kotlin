package com.kings.cursospring

import com.kings.cursospring.model.Topico
import java.util.ArrayList

fun main() {
    val lista = ArrayList<Int>()

    lista.add(0)
    lista.add(1)
    lista.add(2)
    lista.add(3)
    lista.add(4)

    val index = lista.indexOfFirst { it == 10 }
    println(index)
    val topico = lista[index]

    lista[index] = 66

    lista.forEach {
        println(it)
    }

}