package com.github.fabriciolfj.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ExampleOne {
}

fun main() = runBlocking {
    println("My program runs...: ${Thread.currentThread().name}")

    launch {
        longRunningTaks()
    }

    println("My program run ends..: ${Thread.currentThread().name}")
}

suspend fun longRunningTaks() {
    println("executing longRunningTask on..: ${Thread.currentThread().name}")
    delay(1000)
    println("longRunningTask ends on thread..: ${Thread.currentThread().name}")
}