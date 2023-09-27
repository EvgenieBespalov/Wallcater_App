package com.example.data.database.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.database.model.ImageDatabaseModel

@Dao
interface DatabaseDatasource {
    @Insert
    fun saveImageFromDatabase(imageDatabaseModel: ImageDatabaseModel)

    @Delete
    fun deleteImageFromDatabase(imageDatabaseModel: ImageDatabaseModel)

    @Query("SELECT * FROM image_table")
    fun getAllImageFromDatabase(): List<ImageDatabaseModel>

    @Query("SELECT * FROM image_table WHERE id = :id")
    fun getImageByIdFromDatabase(id: String): ImageDatabaseModel
}