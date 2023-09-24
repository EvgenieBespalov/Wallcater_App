package com.example.image_category.domain.usecase

import com.example.image_category.domain.entities.CategoryEntity
import com.example.image_category.domain.repositories.ImageCategoryScreenRepository

class GetListCategoriesUseCase(
    private val repository: ImageCategoryScreenRepository
) {
    suspend operator fun invoke(): List<CategoryEntity> = repository.getListCategories()
}