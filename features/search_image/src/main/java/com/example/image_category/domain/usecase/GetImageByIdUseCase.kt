package com.example.image_category.domain.usecase

import com.example.image_category.domain.entities.ImageEntity
import com.example.image_category.domain.repositories.ImageRepository

internal class GetImageByIdUseCase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(id: String): ImageEntity = repository.getImage(id)
}