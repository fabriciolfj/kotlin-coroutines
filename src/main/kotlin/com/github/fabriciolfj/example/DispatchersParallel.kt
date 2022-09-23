package com.github.fabriciolfj.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DispatchersParallel {
}

fun main() = runBlocking {
    repeat(1000) {
        val dispatcher = Dispatchers.Default.limitedParallelism(3)
        launch(dispatcher) {
            println("Default: runing in thread ${Thread.currentThread().name}")
        }
    }
}