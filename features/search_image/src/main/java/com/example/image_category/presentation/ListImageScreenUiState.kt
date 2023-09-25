package com.example.image_category.presentation

import androidx.paging.PagingData
import com.example.image_category.domain.entities.ImageEntity
import kotlinx.coroutines.flow.Flow

internal sealed interface ListImageScreenUiState{
    object Initial : ListImageScreenUiState
    object Loading : ListImageScreenUiState
    data class Content(val listImage: Flow<PagingData<ImageEntity>>) : ListImageScreenUiState
    data class Error(val message: String?) : ListImageScreenUiState
}