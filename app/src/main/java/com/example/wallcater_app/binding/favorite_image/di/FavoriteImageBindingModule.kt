package com.example.wallcater_app.binding.favorite_image.di

import com.example.data.api.repository.ApiRepository
import com.example.data.database.repository.DatabaseRepository
import com.example.data.wallpaper_manager.repository.WallpaperManagerRepository
import com.example.favorite_image.domain.repositories.ImageRepository
import com.example.wallcater_app.binding.favorite_image.converter.ImageConverterFavoriteImageModule
import com.example.wallcater_app.binding.favorite_image.repository.ImageAdapterFavoriteImageModule
import org.koin.core.module.Module
import org.koin.dsl.module


private fun provideImageAdapterRepository(
    wallpaperManagerRepository: WallpaperManagerRepository,
    databaseRepository: DatabaseRepository,
    converter: ImageConverterFavoriteImageModule
): ImageRepository = ImageAdapterFavoriteImageModule(wallpaperManagerRepository, databaseRepository, converter)

fun provideFavoriteImageBindingModule(): Module =
    module {
        factory { ImageConverterFavoriteImageModule() }

        single {
            provideImageAdapterRepository(
                wallpaperManagerRepository = get(),
                databaseRepository = get(),
                converter = get()
            )
        }
    }