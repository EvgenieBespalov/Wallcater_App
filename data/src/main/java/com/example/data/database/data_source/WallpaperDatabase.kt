package com.example.data.database.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.model.ImageDatabaseModel

@Database(entities = [ImageDatabaseModel::class], version = 1)
internal abstract class WallpaperDatabase : RoomDatabase() {
    abstract fun databaseDatasource() : DatabaseDatasource
}