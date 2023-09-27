package com.example.data.database.repository

import com.example.data.database.data_source.DatabaseDatasource
import com.example.data.database.model.ImageDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class DatabaseRepositoryImpl(
    private val databaseDatasource: DatabaseDatasource
) : DatabaseRepository {
    override suspend fun saveImageFromDatabase(imageDatabaseModel: ImageDatabaseModel) {
        withContext(Dispatchers.IO) {
            databaseDatasource.saveImageFromDatabase(imageDatabaseModel)
        }
    }

    override suspend fun deleteImageFromDatabase(imageDatabaseModel: ImageDatabaseModel) =
        withContext(Dispatchers.IO) {
            databaseDatasource.deleteImageFromDatabase(imageDatabaseModel)
        }

    override suspend fun getAllImageFromDatabase(): List<ImageDatabaseModel> =
        withContext(Dispatchers.IO) {
            databaseDatasource.getAllImageFromDatabase()
        }


    override suspend fun getImageByIdFromDatabase(imageId: String): ImageDatabaseModel =
        withContext(Dispatchers.IO) {
            databaseDatasource.getImageByIdFromDatabase(imageId)
        }
}