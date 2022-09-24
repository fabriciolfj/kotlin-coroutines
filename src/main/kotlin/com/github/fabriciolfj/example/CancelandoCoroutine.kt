package com.github.fabriciolfj.example

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CancelandoCoroutine {
}

fun main() = runBlocking {
    println("First program init")
    val job = launch {
        loggingFunction()
    }

    delay(1900)
    job.cancelAndJoin() //aguarda a coroutine cancelar
    println("end program")
}

suspend fun loggingFunction() {
    repeat(1000) {
        println("executing $it on thread ${Thread.currentThread().name}")
        delay(600)
    }
}