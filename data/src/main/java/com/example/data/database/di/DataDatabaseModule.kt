package com.example.data.database.di

import androidx.room.Room
import com.example.data.api.data_source.CategoryApiDatasource
import com.example.data.api.data_source.ImageApiDatasource
import com.example.data.api.repository.ApiRepository
import com.example.data.api.repository.ApiRepositoryImpl
import com.example.data.database.data_source.DatabaseDatasource
import com.example.data.database.data_source.WallpaperDatabase
import com.example.data.database.repository.DatabaseRepository
import com.example.data.database.repository.DatabaseRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

private fun provideDatabaseRepositoryImpl(
    databaseDatasource: DatabaseDatasource
): DatabaseRepository = DatabaseRepositoryImpl(databaseDatasource)

fun provideDataBaseModule(): Module =
    module{
        single {
            Room.databaseBuilder(androidApplication(), WallpaperDatabase::class.java, "wallpaper_db")
                .fallbackToDestructiveMigration()
                .build()

        }

        single { get<WallpaperDatabase>().databaseDatasource() }

        single { provideDatabaseRepositoryImpl(databaseDatasource = get()) }
    }