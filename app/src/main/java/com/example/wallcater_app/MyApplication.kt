package com.example.wallcater_app

import android.app.Application
import com.example.data.api.di.provideApiModule
import com.example.data.database.di.provideDatabaseModule
import com.example.data.shared_preference.di.provideSharedPreferenceModule
import com.example.data.wallpaper_manager.di.provideWallpaperModule
import com.example.favorite_image.domain.di.provideFavoriteImageModule
import com.example.image_category.domain.di.provideImageCategoryModule
import com.example.wallcater_app.binding.favorite_image.di.provideFavoriteImageBindingModule
import com.example.wallcater_app.binding.search_image.di.provideSearchImageBindingModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                provideImageCategoryModule(),
                provideFavoriteImageModule(),
                provideSearchImageBindingModule(),
                provideFavoriteImageBindingModule(),
                provideApiModule(),
                provideWallpaperModule(),
                provideDatabaseModule(),
                provideSharedPreferenceModule()
            )
        }
    }
}