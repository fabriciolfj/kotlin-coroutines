package com.github.fabriciolfj.example

import kotlinx.coroutines.*
import java.time.Instant

class ExampleTwo {
}

fun main() = runBlocking {
    println("${Instant.now()}: My program runs...: ${Thread.currentThread().name}")

    val productId = findProduct()

    var job = launch (Dispatchers.Unconfined) { // start a coroutine
        val price = fetchPrice(productId) // call the suspending function
    }

    //job.join()//espera a coroutine concluir
    updateProduct()

    println("${Instant.now()}: My program run ends...: " +
            "${Thread.currentThread().name}")
}

suspend fun fetchPrice(productId: String) : Double{
    println("${Instant.now()}: fetchPrice starts on...:${Thread.currentThread().name} ")
    delay(2000) // simulate the slow function by adding a delay
    println("${Instant.now()}: fetchPrice ends on...:${Thread.currentThread().name} ")
    return 234.5
}

fun findProduct() : String{
    println("${Instant.now()}: findProduct on...: ${Thread.currentThread().name}")
    return "P12333"
}

fun updateProduct() : String{
    println("${Instant.now()}: updateProduct on...: ${Thread.currentThread().name}")
    return "Product updated"
}