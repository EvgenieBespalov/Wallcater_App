package com.example.image_category.domain.usecase

import com.example.image_category.domain.entities.ImageEntity
import com.example.image_category.domain.repositories.ImageRepository

class SetWallpapperOnLockScreenUseCase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(urlImage: String) = repository.setWallpapperOnLockScreen(urlImage)
}