package com.example.image_category.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.image_category.domain.usecase.GetImageByIdUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

internal class ImageScreenViewModel(
    private val getImageByIdUseCase: GetImageByIdUseCase
) : ViewModel() {
    private val _state: MutableLiveData<ImageScreenUiState> =
        MutableLiveData(ImageScreenUiState.Initial)
    val state: LiveData<ImageScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = ImageScreenUiState.Initial
        }
    }

    fun getImageById(id: String) {
        viewModelScope.launch {
            _state.value = ImageScreenUiState.Loading

            try {
                val image = getImageByIdUseCase(id)
                _state.value = ImageScreenUiState.Content(image)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ImageScreenUiState.Error(ex.message)
            }
        }
    }
}