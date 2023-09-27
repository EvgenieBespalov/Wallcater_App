package com.example.favorite_image.domain.usecase

import com.example.favorite_image.domain.entites.ImageEntity
import com.example.favorite_image.domain.repositories.ImageRepository

class SaveImageInDatabaseUseCase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(image: ImageEntity) = repository.saveImageInDatabase(image)
}