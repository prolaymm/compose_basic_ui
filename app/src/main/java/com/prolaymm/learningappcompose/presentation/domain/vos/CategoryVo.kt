package com.prolaymm.learningappcompose.presentation.domain.vos


import com.google.gson.annotations.SerializedName


data class CategoryVo (
    @SerializedName("id"         ) var id         : Int?    = null,
    @SerializedName("name"       ) var name       : String? = null,
    @SerializedName("image"      ) var image      : String? = null,
    @SerializedName("creationAt" ) var creationAt : String? = null,
    @SerializedName("updatedAt"  ) var updatedAt  : String? = null

)