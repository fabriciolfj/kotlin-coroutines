package com.github.fabriciolfj.example

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.*

class ExampleThree {
}

fun main() = runBlocking {
    println("program runs...: ${Thread.currentThread().name}")

    val taskDeferred = async {
        generateUniqueID()
    }

    val taskResut = taskDeferred.await()

    println("program run ends...: $taskResut ${Thread.currentThread().name}")
}

suspend fun generateUniqueID(): String{
    println("executing generateUniqueID on...:${Thread.currentThread().name}")
    delay(1000)
    println("generateUniqueID ends on thread ...:${Thread.currentThread().name}")

    return UUID.randomUUID().toString()
}