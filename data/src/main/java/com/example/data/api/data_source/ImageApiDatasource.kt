package com.example.data.api.data_source

import com.example.data.api.model.ImageApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImageApiDatasource {
    @GET("/v1/images/search?mime_types=jpg,png&order=ASC&limit=10&has_breeds=false&include_breeds=false&include_categories=false&api_key=live_YleQhfhS8ytOzT8IbcFnV72Vs71UZA02d7WieOCqyabZdofsI5kDZhbWD57p1OfQ")
    suspend fun getListImages(@Query("page") page: String, @Query("category_ids") categoryId: String): Response<List<ImageApiModel>>

    @GET("/v1/images/{id}")
    suspend fun getImage(@Path("id") id: String): ImageApiModel
}