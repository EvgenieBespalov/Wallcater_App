package com.example.wallcater_app.ui.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallcater_app.ui.domain.usecase.GetThemeUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class MainScreenViewModel(
private val getThemeUseCase: GetThemeUseCase
) : ViewModel() {

    private val _state: MutableLiveData<MainScreenUiState> =
        MutableLiveData(MainScreenUiState.Initial)
    val state: LiveData<MainScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = MainScreenUiState.Initial
        }
    }

    fun getTheme() {
        viewModelScope.launch {
            _state.value = MainScreenUiState.Loading

            try {
                val theme = getThemeUseCase()
                _state.value = MainScreenUiState.Content(theme)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = MainScreenUiState.Error(ex.message)
            }
        }
    }
}