package com.example.wallcater_app.binding.search_image.di

import com.example.data.api.repository.ApiRepository
import com.example.data.database.repository.DatabaseRepository
import com.example.data.wallpaper_manager.repository.WallpaperManagerRepository
import com.example.image_category.domain.repositories.CategoryRepository
import com.example.image_category.domain.repositories.ImageRepository
import com.example.wallcater_app.binding.search_image.converter.CategoryConverterSearchImageModule
import com.example.wallcater_app.binding.search_image.converter.ImageConverterSearchImageModule
import com.example.wallcater_app.binding.search_image.repository.CategoryAdapterSearchImageModule
import com.example.wallcater_app.binding.search_image.repository.ImageAdapterSearchImageModule
import org.koin.core.module.Module
import org.koin.dsl.module

private fun provideCategoryAdapterRepository(
    apiRepository: ApiRepository,
    converter: CategoryConverterSearchImageModule
): CategoryRepository = CategoryAdapterSearchImageModule(apiRepository, converter)

private fun provideImageAdapterRepository(
    apiRepository: ApiRepository,
    wallpaperManagerRepository: WallpaperManagerRepository,
    databaseRepository: DatabaseRepository,
    converter: ImageConverterSearchImageModule
): ImageRepository = ImageAdapterSearchImageModule(apiRepository, wallpaperManagerRepository, databaseRepository, converter)

fun provideSearchImageBindingModule(): Module =
    module {
        factory { CategoryConverterSearchImageModule() }
        factory { ImageConverterSearchImageModule() }

        single {
            provideCategoryAdapterRepository(
                apiRepository = get(),
                converter = get()
            )
        }
        single {
            provideImageAdapterRepository(
                apiRepository = get(),
                wallpaperManagerRepository = get(),
                databaseRepository = get(),
                converter = get()
            )
        }
    }