package com.prolaymm.learningappcompose.presentation.domain

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import com.prolaymm.learningappcompose.presentation.domain.extension.fromJson
import com.prolaymm.learningappcompose.presentation.domain.extension.toJson
import com.prolaymm.learningappcompose.presentation.domain.vos.CourseVo
import java.io.Serializable

data class Post(val title: String ="kotlinPro")

data class MyData(val title: String = "Kotlin Pro")
class CustomNavTyperParser<T>:  NavType<T>(isNullableAllowed = false){
    override fun get(bundle: Bundle, key: String): T? {
       return bundle.getString(key)?.let {
           parseValue(it)
       }
    }

    override fun parseValue(value: String): T {
        return  Gson().fromJson(value,object : TypeToken<Map<String, Any?>>() {}.type)
    }

    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putString(key, value.toJson())
    }

    override fun serializeAsValue(value: T): String {
        return value.toJson()
    }
}
