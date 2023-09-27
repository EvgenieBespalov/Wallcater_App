package com.example.data.wallpaper_manager.di

import com.example.data.wallpaper_manager.repository.WallpaperManagerRepository
import com.example.data.wallpaper_manager.repository.WallpaperManagerRepositoryImpl
import com.example.data.wallpaper_manager.data_source.MyWallpaperManager
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module


private fun provideWallpaperRepositoryImpl(
    wallpaperManager: MyWallpaperManager
): WallpaperManagerRepository = WallpaperManagerRepositoryImpl(wallpaperManager)

fun provideWallpaperModule(): Module =
    module {
        single {
            MyWallpaperManager(androidApplication())
        }
        single {
            provideWallpaperRepositoryImpl(
                wallpaperManager = get()
            )
        }
    }