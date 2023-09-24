package com.example.data.api.model

import com.google.gson.annotations.SerializedName

data class CategoryApiModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)
