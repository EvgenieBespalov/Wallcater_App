package com.example.data.database.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.database.model.ImageDatabaseModel

@Dao
interface DatabaseDatasource {
    @Insert
    fun save(imageDatabaseModel: ImageDatabaseModel)

    @Delete
    fun delete(imageDatabaseModel: ImageDatabaseModel)

    @Query("SELECT * FROM image_table")
    fun getAll(): List<ImageDatabaseModel>

    @Query("SELECT * FROM image_table WHERE id = :id LIMIT 1")
    fun checkSave(id: String): ImageDatabaseModel
}