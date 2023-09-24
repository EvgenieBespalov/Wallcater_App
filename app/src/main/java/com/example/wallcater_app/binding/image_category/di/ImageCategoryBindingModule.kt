package com.example.wallcater_app.binding.image_category.di

import com.example.data.api.repository.ApiRepository
import com.example.image_category.domain.repositories.ImageCategoryScreenRepository
import com.example.wallcater_app.binding.image_category.converter.ImageCategoryConverter
import com.example.wallcater_app.binding.image_category.repository.ImageCategoryScreenAdapterRepository
import org.koin.core.module.Module
import org.koin.dsl.module

private fun provideImageCategoryScreenAdapterRepository(
    apiRepository: ApiRepository,
    imageCategoryConverter: ImageCategoryConverter
): ImageCategoryScreenRepository = ImageCategoryScreenAdapterRepository(apiRepository, imageCategoryConverter)

fun provideImageCategoryBindingModule(): Module =
    module {
        factory { ImageCategoryConverter() }
        single {
            provideImageCategoryScreenAdapterRepository(
                apiRepository = get(),
                imageCategoryConverter = get()
            )
        }
    }