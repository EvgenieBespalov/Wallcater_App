package com.example.image_category.domain.usecase

import androidx.paging.PagingData
import com.example.image_category.domain.entities.ImageEntity
import com.example.image_category.domain.repositories.ImageRepository
import kotlinx.coroutines.flow.Flow

internal class GetListImagesUseCase(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(categoryId: String): Flow<PagingData<ImageEntity>> = repository.getListImages(categoryId)
}