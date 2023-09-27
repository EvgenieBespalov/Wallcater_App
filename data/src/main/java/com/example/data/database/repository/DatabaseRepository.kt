package com.example.data.database.repository

import com.example.data.database.model.ImageDatabaseModel

interface DatabaseRepository {
    suspend fun saveImageFromDatabase(imageDatabaseModel: ImageDatabaseModel)

    suspend fun deleteImageFromDatabase(imageDatabaseModel: ImageDatabaseModel)

    suspend fun getAllImageFromDatabase(): List<ImageDatabaseModel>

    suspend fun getImageByIdFromDatabase(imageId: String): ImageDatabaseModel
}