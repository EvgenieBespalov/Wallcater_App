package com.example.favorite_image.domain.usecase

import com.example.favorite_image.domain.repositories.ImageRepository

class CheckSaveImageInDatabaseUseCase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(idImage: String): Boolean = repository.checkSaveImageInDatabase(idImage)
}