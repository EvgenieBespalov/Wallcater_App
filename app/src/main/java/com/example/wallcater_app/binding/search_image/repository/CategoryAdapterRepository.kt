package com.example.wallcater_app.binding.search_image.repository

import com.example.data.api.repository.ApiRepository
import com.example.image_category.domain.entities.CategoryEntity
import com.example.image_category.domain.repositories.CategoryRepository
import com.example.wallcater_app.binding.search_image.converter.CategoryConverter

class CategoryAdapterRepository(
    private val apiRepository: ApiRepository,
    private val categoryConverter: CategoryConverter
) : CategoryRepository {
    override suspend fun getListCategories(): List<CategoryEntity> =
        apiRepository.getCategories().map { categoryConverter.convertApiModelToEntity(it) }
}