package com.example.data.database.repository

import com.example.data.database.data_source.DatabaseDatasource
import com.example.data.database.model.ImageDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class DatabaseRepositoryImpl(
    private val databaseDatasource: DatabaseDatasource
) : DatabaseRepository {
    override suspend fun saveImage(imageDatabaseModel: ImageDatabaseModel) {
        withContext(Dispatchers.IO) {
            databaseDatasource.save(imageDatabaseModel)
        }
    }

    override suspend fun deleteImage(imageDatabaseModel: ImageDatabaseModel) =
        withContext(Dispatchers.IO) {
            databaseDatasource.delete(imageDatabaseModel)
        }

    override suspend fun getAllImage(): List<ImageDatabaseModel> =
        withContext(Dispatchers.IO) {
            databaseDatasource.getAll()
        }


    override suspend fun checkSave(imageId: String): ImageDatabaseModel =
        withContext(Dispatchers.IO) {
            databaseDatasource.checkSave(imageId)
        }
}