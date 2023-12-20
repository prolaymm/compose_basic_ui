package com.prolaymm.learningappcompose.presentation.kotlin_test

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {


   runBlocking {
       makeFlow().map {
           it*10
       }
           .collect {
           println(it)
       }
   }

}

suspend  fun makeFlow() : Flow<Int> {

    val list = listOf<Int>(1,3,3,4)

   return  flow{
        list.forEach{
            delay(2000)
            emit(it)
        }
    }
}