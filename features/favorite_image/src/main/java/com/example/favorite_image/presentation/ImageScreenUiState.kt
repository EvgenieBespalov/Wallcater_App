package com.example.favorite_image.presentation

import com.example.favorite_image.domain.entites.ImageEntity


internal sealed interface ImageScreenUiState{
    object Initial : ImageScreenUiState
    object Loading : ImageScreenUiState
    data class Content(val image: ImageEntity, val checkSaveInDatabase: Boolean) : ImageScreenUiState
    data class Error(val message: String?) : ImageScreenUiState
}