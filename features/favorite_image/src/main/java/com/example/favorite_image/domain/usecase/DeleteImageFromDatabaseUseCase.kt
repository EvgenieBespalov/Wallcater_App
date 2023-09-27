package com.example.favorite_image.domain.usecase

import com.example.favorite_image.domain.entites.ImageEntity
import com.example.favorite_image.domain.repositories.ImageRepository


class DeleteImageFromDatabaseUseCase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(imageEntity: ImageEntity) = repository.deleteImageFromDatabase(imageEntity)
}