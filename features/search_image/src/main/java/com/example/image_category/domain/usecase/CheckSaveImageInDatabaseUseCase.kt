package com.example.image_category.domain.usecase

import com.example.image_category.domain.repositories.ImageRepository

class CheckSaveImageInDatabaseUseCase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(idImage: String): Boolean = repository.checkSaveImageInDatabase(idImage)
}