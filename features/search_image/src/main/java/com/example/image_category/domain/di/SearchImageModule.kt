package com.example.image_category.domain.di

import android.app.WallpaperManager
import android.content.Context
import com.example.image_category.domain.usecase.*
import com.example.image_category.domain.usecase.GetImageByIdUseCase
import com.example.image_category.domain.usecase.GetListCategoriesUseCase
import com.example.image_category.domain.usecase.GetListImagesUseCase
import com.example.image_category.presentation.ImageScreenViewModel
import com.example.image_category.presentation.ListCategoryScreenViewModel
import com.example.image_category.presentation.ListImageScreenViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import java.io.InputStream
import java.net.URL

fun provideImageCategoryModule(): Module =
    module {
        viewModel {
            ListCategoryScreenViewModel(
                getListCategoriesUseCase = get(),
            )
        }
        factory { GetListCategoriesUseCase(repository = get()) }

        viewModel {
            ListImageScreenViewModel(
                getListImagesUseCase = get(),
            )
        }
        factory { GetListImagesUseCase(repository = get()) }

        viewModel {
            ImageScreenViewModel(
                getImageByIdUseCase = get(),
                setWallpapperOnLockScreenUseCase = get(),
                setWallpapperOnSystemScreenUseCase = get(),
                checkSaveImageInDatabaseUseCase = get(),
                saveImageInDatabaseUseCase = get(),
                deleteImageFromDatabaseUseCase = get()
            )
        }
        factory { GetImageByIdUseCase(repository = get()) }
        factory { SetWallpapperOnLockScreenUseCase(repository = get()) }
        factory { SetWallpapperOnSystemScreenUseCase(repository = get()) }
        factory { CheckSaveImageInDatabaseUseCase(repository = get()) }
        factory { SaveImageInDatabaseUseCase(repository = get()) }
        factory { DeleteImageFromDatabaseUseCase(repository = get()) }
    }

