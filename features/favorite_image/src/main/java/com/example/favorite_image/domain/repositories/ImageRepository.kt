package com.example.favorite_image.domain.repositories

import com.example.favorite_image.domain.entites.ImageEntity

interface ImageRepository {
    suspend fun getListImages(): List<ImageEntity>
    suspend fun getImage(id: String): ImageEntity
    suspend fun setWallpapperOnLockScreen(urlImage: String)
    suspend fun setWallpapperOnSystemScreen(urlImage: String)
    suspend fun saveImageInDatabase(imageEntity: ImageEntity)
    suspend fun deleteImageFromDatabase(imageEntity: ImageEntity)
    suspend fun checkSaveImageInDatabase(idImage: String): Boolean
}