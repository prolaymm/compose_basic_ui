package com.prolaymm.learningappcompose.presentation.domain.data

import android.content.Context
import com.google.gson.Gson
import java.lang.reflect.Type


class CustomJsonReader<T> {

    fun onReadJsonDataFromAsset(context: Context, assetFile: String, typeToken: Type): T {
        val fileInString: String =
            context.assets.open(assetFile).bufferedReader().use { it.readText() }
        return Gson().fromJson<T>(fileInString, typeToken)
    }

    fun jsonToDataObject( jsonFile: String, typeToken: Type): T {
        return Gson().fromJson<T>(jsonFile, typeToken)
    }


}