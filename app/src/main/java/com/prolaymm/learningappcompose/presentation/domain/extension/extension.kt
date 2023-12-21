package com.prolaymm.learningappcompose.presentation.domain.extension

import com.google.gson.Gson

fun <A> A.toJson(): String {
    return Gson().toJson(this)
}

fun <A> String.fromJson(type: Class<A>): A {
    return Gson().fromJson(this, type)
}
