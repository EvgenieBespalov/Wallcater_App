package com.example.settings.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.settings.domain.usecase.ChangeThemeUseCase
import com.example.settings.domain.usecase.GetThemeUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

internal class SettingsScreenViewModel(
    private val changeThemeUseCase: ChangeThemeUseCase,
    private val getThemeUseCase: GetThemeUseCase
) : ViewModel() {

    private val _state: MutableLiveData<SettingsScreenUiState> =
        MutableLiveData(SettingsScreenUiState.Initial)
    val state: LiveData<SettingsScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = SettingsScreenUiState.Initial
        }
    }

    fun getTheme() {
        viewModelScope.launch {
            _state.value = SettingsScreenUiState.Loading

            try {
                val theme = getThemeUseCase()
                _state.value = SettingsScreenUiState.Content(theme)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = SettingsScreenUiState.Error(ex.message)
            }
        }
    }

    fun changeTheme(theme: Boolean){
        viewModelScope.launch {
            _state.value = SettingsScreenUiState.Loading

            try {
                changeThemeUseCase(theme)
                _state.value = SettingsScreenUiState.Initial
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = SettingsScreenUiState.Error(ex.message)
            }
        }
    }
}