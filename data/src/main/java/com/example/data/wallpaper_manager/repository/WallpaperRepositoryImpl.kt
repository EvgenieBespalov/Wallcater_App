package com.example.data.wallpaper_manager.repository

import com.example.data.wallpaper_manager.wallpaper_manager.MyWallpaperManager

class WallpaperRepositoryImpl(
    private val wallpaperManager: MyWallpaperManager
) : WallpaperRepository {
    override suspend fun setWallpapperOnLockScreen(urlImage: String) = wallpaperManager.setWallpapperOnLockScreen(urlImage)
    override suspend fun setWallpapperOnSystemScreen(urlImage: String) = wallpaperManager.setWallpapperOnSystemScreen(urlImage)
}