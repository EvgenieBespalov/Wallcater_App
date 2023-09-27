package com.example.image_category.domain.usecase

import com.example.image_category.domain.entities.ImageEntity
import com.example.image_category.domain.repositories.ImageRepository

class SaveImageInDatabaseUseCase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(image: ImageEntity) = repository.saveImageInDatabase(image)
}