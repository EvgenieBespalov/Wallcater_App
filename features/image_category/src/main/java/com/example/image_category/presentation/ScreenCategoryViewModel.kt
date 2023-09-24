package com.example.image_category.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.image_category.domain.usecase.GetListCategoriesUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class ScreenCategoryViewModel(
    private val getListCategoriesUseCase: GetListCategoriesUseCase
) : ViewModel() {

    private val _state: MutableLiveData<ScreenCategoryUiState> =
        MutableLiveData(ScreenCategoryUiState.Initial)
    val state: LiveData<ScreenCategoryUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = ScreenCategoryUiState.Initial
        }
    }

    fun getListCategories() {
        viewModelScope.launch {
            _state.value = ScreenCategoryUiState.Loading

            try {
                val listCategories = getListCategoriesUseCase()
                _state.value = ScreenCategoryUiState.Content(listCategories)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ScreenCategoryUiState.Error(ex.message)
            }

        }
    }
}