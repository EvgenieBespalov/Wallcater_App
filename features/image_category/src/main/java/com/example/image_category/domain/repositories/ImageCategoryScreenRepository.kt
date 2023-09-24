package com.example.image_category.domain.repositories

import androidx.paging.PagingData
import com.example.image_category.domain.entities.CategoryEntity
import com.example.image_category.domain.entities.ImageEntity
import kotlinx.coroutines.flow.Flow

interface ImageCategoryScreenRepository {
    suspend fun getListCategories(): List<CategoryEntity>
    suspend fun getListImage(): Flow<PagingData<ImageEntity>>
    suspend fun getImageId(id: String): ImageEntity
}