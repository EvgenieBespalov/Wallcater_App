package com.example.data.database.repository

import com.example.data.database.model.ImageDatabaseModel

interface DatabaseRepository {
    suspend fun saveImage(imageDatabaseModel: ImageDatabaseModel)

    suspend fun deleteImage(imageDatabaseModel: ImageDatabaseModel)

    suspend fun getAllImage(): List<ImageDatabaseModel>

    suspend fun checkSave(imageId: String): ImageDatabaseModel
}