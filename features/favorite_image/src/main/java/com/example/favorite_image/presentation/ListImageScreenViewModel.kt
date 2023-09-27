package com.example.favorite_image.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favorite_image.domain.usecase.GetListImagesUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

internal class ListImageScreenViewModel(
    private val getListImagesUseCase: GetListImagesUseCase
) : ViewModel() {

    private val _state: MutableLiveData<ListImageScreenUiState> =
        MutableLiveData(ListImageScreenUiState.Initial)
    val state: LiveData<ListImageScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = ListImageScreenUiState.Initial
        }
    }

    fun getListImages() {
        viewModelScope.launch {
            _state.value = ListImageScreenUiState.Loading

            try {
                val listImages = getListImagesUseCase()
                _state.value = ListImageScreenUiState.Content(listImages)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ListImageScreenUiState.Error(ex.message)
            }

        }
    }
}