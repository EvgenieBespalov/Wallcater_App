package com.example.data.wallpaper_manager.wallpaper_manager

import android.app.WallpaperManager
import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

internal class MyWallpaperManager(context: Context){
    val wallpaperManager: WallpaperManager = WallpaperManager.getInstance(context)

    suspend fun setWallpapperOnLockScreen(urlImage: String){
        withContext(Dispatchers.IO) {
            val inputStream = URL(urlImage).openStream()

            wallpaperManager.setStream(inputStream, null, true, WallpaperManager.FLAG_LOCK)
        }
    }

    suspend fun setWallpapperOnSystemScreen(urlImage: String){
        withContext(Dispatchers.IO) {
            val inputStream = URL(urlImage).openStream()

            wallpaperManager.setStream(inputStream, null, true, WallpaperManager.FLAG_SYSTEM)
        }
    }
}