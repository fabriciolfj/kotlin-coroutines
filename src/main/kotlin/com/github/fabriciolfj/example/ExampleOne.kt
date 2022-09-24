package com.github.fabriciolfj.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ExampleOne {
}

fun main() = runBlocking {
    println("init program ${Thread.currentThread().name}")

    val job = launch {
        loggingTest()
    }

   // job.join()
    println("end program ${Thread.currentThread().name}")
}

suspend fun loggingTest() {
    println("init funcion logging ${Thread.currentThread().name}")
    delay(1000)
    println("end function logging ${Thread.currentThread().name}")
}