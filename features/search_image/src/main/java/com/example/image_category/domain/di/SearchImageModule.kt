package com.example.image_category.domain.di

import com.example.image_category.domain.usecase.GetImageByIdUseCase
import com.example.image_category.domain.usecase.GetListCategoriesUseCase
import com.example.image_category.domain.usecase.GetListImagesUseCase
import com.example.image_category.presentation.ImageScreenViewModel
import com.example.image_category.presentation.ListCategoryScreenViewModel
import com.example.image_category.presentation.ListImageScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

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
            )
        }
        factory { GetImageByIdUseCase(repository = get()) }
    }