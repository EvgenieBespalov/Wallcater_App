package com.example.image_category.domain.repositories

import androidx.paging.PagingData
import com.example.image_category.domain.entities.ImageEntity
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    suspend fun getListImages(categoryId: String): Flow<PagingData<ImageEntity>>
    suspend fun getImage(id: String): ImageEntity
    suspend fun setWallpapperOnLockScreen(urlImage: String)
    suspend fun setWallpapperOnSystemScreen(urlImage: String)
    suspend fun saveImageInDatabase(imageEntity: ImageEntity)
    suspend fun getAllImageFromDatabase(): List<ImageEntity>
    suspend fun checkSaveImageInDatabase(idImage: String): Boolean
}