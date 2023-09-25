package com.example.image_category.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.image_category.domain.usecase.GetListCategoriesUseCase
import com.example.image_category.domain.usecase.GetListImagesUseCase
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

    fun getListImages(categoryId: String) {
        viewModelScope.launch {
            _state.value = ListImageScreenUiState.Loading

            try {
                val listImages = getListImagesUseCase(categoryId)
                _state.value = ListImageScreenUiState.Content(listImages)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ListImageScreenUiState.Error(ex.message)
            }

        }
    }
}