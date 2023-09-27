package com.example.favorite_image.domain.usecase

import com.example.favorite_image.domain.entites.ImageEntity
import com.example.favorite_image.domain.repositories.ImageRepository

internal class GetImageByIdUseCase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(id: String): ImageEntity = repository.getImage(id)
}