package com.example.image_category.domain.repositories

import androidx.paging.PagingData
import com.example.image_category.domain.entities.CategoryEntity
import com.example.image_category.domain.entities.ImageEntity
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getListCategories(): List<CategoryEntity>
}