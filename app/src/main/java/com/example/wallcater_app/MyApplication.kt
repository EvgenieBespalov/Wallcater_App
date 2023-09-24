package com.example.wallcater_app

import android.app.Application
import com.example.data.di.provideApiModule
import com.example.image_category.domain.di.provideImageCategoryModule
import com.example.wallcater_app.binding.image_category.di.provideImageCategoryBindingModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                provideApiModule(),
                provideImageCategoryModule(),
                provideImageCategoryBindingModule()
            )
        }
    }
}