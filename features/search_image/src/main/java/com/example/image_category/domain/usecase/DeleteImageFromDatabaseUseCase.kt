package com.example.image_category.domain.usecase

import com.example.image_category.domain.entities.ImageEntity
import com.example.image_category.domain.repositories.ImageRepository

class DeleteImageFromDatabaseUseCase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(imageEntity: ImageEntity) = repository.deleteImageFromDatabase(imageEntity)
}