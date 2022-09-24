package com.github.fabriciolfj.example

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

class ExemploYield {
}

fun main() = runBlocking{
    try {
        val job1 = launch {
            repeat(20){
                println(
                    "processing job 1: ${Thread.currentThread().name}")
                yield()
            }
        }

        val job2 = launch {
            repeat(20){
                println(
                    "processing job 2: ${Thread.currentThread().name}")
                yield()
            }
        }

        job1.join()
        job2.join()

    } catch (e: CancellationException) {
        // clean up code

    }
}