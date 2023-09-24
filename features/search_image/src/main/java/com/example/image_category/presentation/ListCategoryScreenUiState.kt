package com.example.image_category.presentation

import com.example.image_category.domain.entities.CategoryEntity

sealed interface ListCategoryScreenUiState{
    object Initial : ListCategoryScreenUiState
    object Loading : ListCategoryScreenUiState
    data class Content(val listCategory: List<CategoryEntity>) : ListCategoryScreenUiState
    data class Error(val message: String?) : ListCategoryScreenUiState
}