package com.example.wallcater_app.binding.image_category.repository

import androidx.paging.PagingData
import com.example.data.api.repository.ApiRepository
import com.example.image_category.domain.entities.CategoryEntity
import com.example.image_category.domain.entities.ImageEntity
import com.example.image_category.domain.repositories.ImageCategoryScreenRepository
import com.example.wallcater_app.binding.image_category.converter.ImageCategoryConverter
import kotlinx.coroutines.flow.Flow

class ImageCategoryScreenAdapterRepository(
    private val apiRepository: ApiRepository,
    private val imageCategoryConverter: ImageCategoryConverter
) : ImageCategoryScreenRepository {
    override suspend fun getListCategories(): List<CategoryEntity> = apiRepository.getCategories().map { imageCategoryConverter.convertCategoryApiModelToEntity(it) }

    override suspend fun getListImage(): Flow<PagingData<ImageEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getImageId(id: String): ImageEntity {
        TODO("Not yet implemented")
    }
}