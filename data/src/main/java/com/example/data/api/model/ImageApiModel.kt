package com.example.data.api.model

import com.google.gson.annotations.SerializedName

data class ImageApiModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("categories")
    val categories: List<CategoryApiModel>?
)
