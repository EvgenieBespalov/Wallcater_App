package com.example.favorite_image.domain.usecase

import com.example.favorite_image.domain.entites.ImageEntity
import com.example.favorite_image.domain.repositories.ImageRepository

internal class GetListImagesUseCase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(): List<ImageEntity> = repository.getListImages()
}