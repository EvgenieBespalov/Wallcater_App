package com.example.favorite_image.presentation

import com.example.favorite_image.domain.entites.ImageEntity

internal sealed interface ListImageScreenUiState{
    object Initial : ListImageScreenUiState
    object Loading : ListImageScreenUiState
    data class Content(val listImage: List<ImageEntity>) : ListImageScreenUiState
    data class Error(val message: String?) : ListImageScreenUiState
}