package com.example.settings.presentation

internal sealed interface SettingsScreenUiState {
    object Initial : SettingsScreenUiState
    object Loading : SettingsScreenUiState
    data class Content(val theme: Boolean) : SettingsScreenUiState
    data class Error(val message: String?) : SettingsScreenUiState
}