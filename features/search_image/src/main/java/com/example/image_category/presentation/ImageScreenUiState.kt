package com.example.image_category.presentation

import com.example.image_category.domain.entities.ImageEntity


internal sealed interface ImageScreenUiState{
    object Initial : ImageScreenUiState
    object Loading : ImageScreenUiState
    data class Content(val image: ImageEntity, val checkSaveInDatabase: Boolean) : ImageScreenUiState
    data class Error(val message: String?) : ImageScreenUiState
}