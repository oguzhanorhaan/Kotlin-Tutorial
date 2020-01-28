package com.oguzhanorhan

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlin.system.measureTimeMillis

class AsyncAwaitExampleActivity {

    /**
     * Job1 and Job2 run in parallel as different coroutines
     */
    private suspend fun fakeApiRequest() {
        withContext(IO) {

            val job1 = launch {
                val time1 = measureTimeMillis {
                    println("debug: launching job1 in thread: ${Thread.currentThread().name}")
                    val result1 = getResult1FromApi()
                    //setTextOnMainThread("Got $result1")
                }
                println("debug: compeleted job1 in $time1 ms.")
            }

            val job2 = launch {
                val time2 = measureTimeMillis {
                    println("debug: launching job2 in thread: ${Thread.currentThread().name}")
                    val result2 = getResult2FromApi()
                  //  setTextOnMainThread("Got $result2")
                }
                println("debug: compeleted job2 in $time2 ms.")
            }

        }
    }

    private suspend fun fakeApiRequest2() {
        CoroutineScope(IO).launch {
            val executionTime = measureTimeMillis {
                val result: Deferred<String> = async {
                    println("launching job1")
                    getResult1FromApi()
                }

                val result2: Deferred<String> = async {
                    println("launching job2")
                    getResult1FromApi()
                }

                println(result.await())
                println(result2.await())
            }

            println("Total time elapsed $executionTime")
        }
    }

    private suspend fun getResult1FromApi(): String {
        delay(1000)
        return "Result #1"
    }

    private suspend fun getResult2FromApi(): String {
        delay(1500)
        return "Result #2"
    }
}