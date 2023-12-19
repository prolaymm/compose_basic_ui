package com.prolaymm.learningappcompose.presentation.domain.extension

import com.google.gson.Gson

fun Any.toJson() :String{
    return Gson().toJson(this)
}

