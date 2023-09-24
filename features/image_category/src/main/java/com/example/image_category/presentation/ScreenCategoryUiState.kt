package com.example.image_category.presentation

import com.example.image_category.domain.entities.CategoryEntity

sealed interface ScreenCategoryUiState{
    object Initial : ScreenCategoryUiState
    object Loading : ScreenCategoryUiState
    data class Content(val listCategory: List<CategoryEntity>) : ScreenCategoryUiState
    data class Error(val message: String?) : ScreenCategoryUiState
}