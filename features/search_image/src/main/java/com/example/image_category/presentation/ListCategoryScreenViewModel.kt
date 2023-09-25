package com.example.image_category.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.image_category.domain.usecase.GetListCategoriesUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

internal class ListCategoryScreenViewModel(
    private val getListCategoriesUseCase: GetListCategoriesUseCase,
    //private val routes: ListCategoryScreenRoutes
) : ViewModel() {

    private val _state: MutableLiveData<ListCategoryScreenUiState> =
        MutableLiveData(ListCategoryScreenUiState.Initial)
    val state: LiveData<ListCategoryScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = ListCategoryScreenUiState.Initial
        }
    }

  /*  fun launchListImageScreen(){
        routes.launchListImageScreen()
    }*/

    fun getListCategories() {
        viewModelScope.launch {
            _state.value = ListCategoryScreenUiState.Loading

            try {
                val listCategories = getListCategoriesUseCase()
                _state.value = ListCategoryScreenUiState.Content(listCategories)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ListCategoryScreenUiState.Error(ex.message)
            }

        }
    }
}