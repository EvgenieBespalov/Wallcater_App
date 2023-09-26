package com.example.data.api.di

import android.service.controls.ControlsProviderService
import android.util.Log
import com.example.data.api.data_source.CategoryApiDatasource
import com.example.data.api.data_source.ImageApiDatasource
import com.example.data.api.repository.ApiRepository
import com.example.data.api.repository.ApiRepositoryImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://api.thecatapi.com/"
private const val CONNECT_TIMEOUT = 10L
private const val WRITE_TIMEOUT = 10L
private const val READ_TIMEOUT = 10L

private fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient().newBuilder()
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(ReceivedCookiesInterceptor())
        .build()

private fun provideGson(): Gson =
    GsonBuilder()
        .create()

private fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit =
    Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

private fun provideCategoryApiDatasourse(retrofit: Retrofit): CategoryApiDatasource =
    retrofit.create()

private fun provideImageApiDatasourse(retrofit: Retrofit): ImageApiDatasource =
    retrofit.create()

private fun provideApiRepositoryImpl(
    categoryApiDatasource: CategoryApiDatasource,
    imageApiDatasource: ImageApiDatasource
): ApiRepository = ApiRepositoryImpl(categoryApiDatasource, imageApiDatasource)

fun provideApiModule(): Module =
    module {
        single { provideOkHttpClient() }
        single { provideGson() }
        single { provideRetrofit(okHttpClient = get(), gson = get()) }
        single { provideCategoryApiDatasourse(retrofit = get()) }
        single { provideImageApiDatasourse(retrofit = get()) }
        single { provideApiRepositoryImpl(categoryApiDatasource = get(), imageApiDatasource = get()) }
    }

class ReceivedCookiesInterceptor() : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response
    {
        val request = chain.request()
        var response = chain.proceed(request)

        Log.i(ControlsProviderService.TAG, "request: "+ request.toString())
        Log.i(ControlsProviderService.TAG, "response: "+ response.toString())

        return response
    }
}