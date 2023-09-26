package com.example.data.database.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "image_table", primaryKeys = ["id"])
data class ImageDatabaseModel(
    val id: String,
    val url: String,
    val width: String,
    val height: String,
)
