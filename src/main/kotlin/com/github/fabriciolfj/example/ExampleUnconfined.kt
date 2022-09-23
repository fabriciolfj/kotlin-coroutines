package com.github.fabriciolfj.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ExampleUnconfined {
}

fun main() = runBlocking {
    println("start main..: ${Thread.currentThread().name}")

    launch(Dispatchers.Unconfined) {
        logging()
    }

    println("end main..: ${Thread.currentThread().name}")
}

suspend fun logging() {
    println("start logging..: ${Thread.currentThread().name}")
    delay(1000)
    println("end logging..: ${Thread.currentThread().name}")
}