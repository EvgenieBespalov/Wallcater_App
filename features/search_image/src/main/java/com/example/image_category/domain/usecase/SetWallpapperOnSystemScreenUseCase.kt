package com.example.image_category.domain.usecase

import com.example.image_category.domain.repositories.ImageRepository

internal class SetWallpapperOnSystemScreenUseCase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(urlImage: String) = repository.setWallpapperOnSystemScreen(urlImage)
}