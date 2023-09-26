package com.example.data.wallpaper_manager.repository

interface WallpaperManagerRepository {
    suspend fun setWallpapperOnLockScreen(urlImage: String)

    suspend fun setWallpapperOnSystemScreen(urlImage: String)
}