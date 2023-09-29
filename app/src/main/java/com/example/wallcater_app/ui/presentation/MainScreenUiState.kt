package com.example.wallcater_app.ui.presentation

sealed interface MainScreenUiState{
    object Initial : MainScreenUiState
    object Loading : MainScreenUiState
    data class Content(val theme: Boolean) : MainScreenUiState
    data class Error(val message: String?) : MainScreenUiState
}