package com.example.data.api.data_source

import com.example.data.api.model.CategoryApiModel
import com.example.data.api.model.ImageApiModel
import retrofit2.http.GET

interface CategoryApiDatasource {
    @GET("/v1/categories")
    suspend fun getCategories(): List<CategoryApiModel>
}