package com.example.data.wallpaper_manager.repository

import com.example.data.wallpaper_manager.data_source.MyWallpaperManager

internal class WallpaperManagerRepositoryImpl(
    private val wallpaperManager: MyWallpaperManager
) : WallpaperManagerRepository {
    override suspend fun setWallpapperOnLockScreen(urlImage: String) = wallpaperManager.setWallpapperOnLockScreen(urlImage)
    override suspend fun setWallpapperOnSystemScreen(urlImage: String) = wallpaperManager.setWallpapperOnSystemScreen(urlImage)
}