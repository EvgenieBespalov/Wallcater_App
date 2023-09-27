package com.example.favorite_image.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favorite_image.domain.entites.ImageEntity
import com.example.favorite_image.domain.usecase.*
import com.example.favorite_image.domain.usecase.GetImageByIdUseCase
import com.example.favorite_image.domain.usecase.SetWallpapperOnLockScreenUseCase
import com.example.favorite_image.domain.usecase.SetWallpapperOnSystemScreenUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

internal class ImageScreenViewModel(
    private val getImageByIdUseCase: GetImageByIdUseCase,
    private val setWallpapperOnLockScreenUseCase: SetWallpapperOnLockScreenUseCase,
    private val setWallpapperOnSystemScreenUseCase: SetWallpapperOnSystemScreenUseCase,
    private val checkSaveImageInDatabaseUseCase: CheckSaveImageInDatabaseUseCase,
    private val saveImageInDatabaseUseCase: SaveImageInDatabaseUseCase,
    private val deleteImageFromDatabaseUseCase: DeleteImageFromDatabaseUseCase
) : ViewModel() {
    private val _state: MutableLiveData<ImageScreenUiState> =
        MutableLiveData(ImageScreenUiState.Initial)
    val state: LiveData<ImageScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = ImageScreenUiState.Initial
        }
    }

    fun getImageById(idImage: String) {
        viewModelScope.launch {
            _state.value = ImageScreenUiState.Loading

            try {
                val image = getImageByIdUseCase(idImage)
                val checkSaveInDatabase = checkSaveImageInDatabaseUseCase(idImage)
                _state.value = ImageScreenUiState.Content(image, checkSaveInDatabase)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ImageScreenUiState.Error(ex.message)
            }
        }
    }

    fun setWallpapperOnLockScreen(urlImage: String) {
        viewModelScope.launch {
            try {
                setWallpapperOnLockScreenUseCase(urlImage)
                _state.value = ImageScreenUiState.Initial
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ImageScreenUiState.Error(ex.message)
            }
        }
    }
    fun setWallpapperOnSystemScreen(urlImage: String) {
        viewModelScope.launch {
            try {
                setWallpapperOnSystemScreenUseCase(urlImage)
                _state.value = ImageScreenUiState.Initial
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ImageScreenUiState.Error(ex.message)
            }
        }
    }

    fun saveImageInDatabase(image: ImageEntity){
        viewModelScope.launch {
            try {
                saveImageInDatabaseUseCase(image)
                _state.value = ImageScreenUiState.Initial
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ImageScreenUiState.Error(ex.message)
            }
        }
    }

    fun deleteImageInDatabase(image: ImageEntity){
        viewModelScope.launch {
            try {
                deleteImageFromDatabaseUseCase(image)
                _state.value = ImageScreenUiState.Initial
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ImageScreenUiState.Error(ex.message)
            }
        }
    }
}