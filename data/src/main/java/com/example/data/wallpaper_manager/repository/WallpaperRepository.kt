package com.example.data.wallpaper_manager.repository

interface WallpaperRepository {
    suspend fun setWallpapperOnLockScreen(urlImage: String)

    suspend fun setWallpapperOnSystemScreen(urlImage: String)
}