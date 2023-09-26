package com.example.data.wallpaper_manager.di

import com.example.data.wallpaper_manager.repository.WallpaperRepository
import com.example.data.wallpaper_manager.repository.WallpaperRepositoryImpl
import com.example.data.wallpaper_manager.wallpaper_manager.MyWallpaperManager
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module


private fun provideWallpaperRepositoryImpl(
    wallpaperManager: MyWallpaperManager
): WallpaperRepository = WallpaperRepositoryImpl(wallpaperManager)

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