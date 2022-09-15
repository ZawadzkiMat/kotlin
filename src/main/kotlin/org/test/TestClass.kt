package org.test

import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

@State(Scope.Thread)
@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
open class TestClass {

    @JvmStatic
    fun main(args : Array<String>)

        @Benchmark
        @Threads(1)
        @Measurement(time = 1, timeUnit = TimeUnit.SECONDS, iterations = 1)
        fun matrixOneThreads(params: Params) {
            params.i = 0
            while (params.i < params.x.size) {
                params.j = 0
                while (params.j < params.y.size) {
                    params.multi[params.i][params.j] = params.x[params.i][params.j] * params.y[params.i][params.j]
                    params.j++
                }
                params.i++
            }
        }

    }


