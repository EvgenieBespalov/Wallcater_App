package com.example.favorite_image.domain.usecase

import com.example.favorite_image.domain.repositories.ImageRepository

internal class SetWallpapperOnLockScreenUseCase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(urlImage: String) = repository.setWallpapperOnLockScreen(urlImage)
}