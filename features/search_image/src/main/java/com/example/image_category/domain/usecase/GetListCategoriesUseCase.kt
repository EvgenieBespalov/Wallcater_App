package com.example.image_category.domain.usecase

import com.example.image_category.domain.entities.CategoryEntity
import com.example.image_category.domain.repositories.CategoryRepository

internal class GetListCategoriesUseCase(
    private val repository: CategoryRepository
) {
    suspend operator fun invoke(): List<CategoryEntity> = repository.getListCategories()
}