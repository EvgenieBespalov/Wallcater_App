package com.example.data.api.repository

import androidx.paging.PagingData
import com.example.data.api.model.CategoryApiModel
import com.example.data.api.model.ImageApiModel
import kotlinx.coroutines.flow.Flow

interface ApiRepository {
    suspend fun getListImages(categoryId: String): Flow<PagingData<ImageApiModel>>
    suspend fun getImage(id: String): ImageApiModel
    suspend fun getCategories(): List<CategoryApiModel>
}