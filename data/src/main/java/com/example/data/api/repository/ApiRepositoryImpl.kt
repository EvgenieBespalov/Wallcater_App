package com.example.data.api.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.api.data_source.CategoryApiDatasource
import com.example.data.api.data_source.ImageApiDatasource
import com.example.data.api.model.CategoryApiModel
import com.example.data.api.model.ImageApiModel
import com.example.data.api.paging_source.ImagePagingSource
import kotlinx.coroutines.flow.Flow

internal class ApiRepositoryImpl(
    private val categoryApiDatasource: CategoryApiDatasource,
    private val imageApiDatasource: ImageApiDatasource
) : ApiRepository{
    override suspend fun getListImages(categoryId: String): Flow<PagingData<ImageApiModel>> =
        Pager(PagingConfig(10)){
            ImagePagingSource(imageApiDatasource, categoryId)
        }.flow

    override suspend fun getImage(id: String): ImageApiModel =
        imageApiDatasource.getImage(id)

    override suspend fun getCategories(): List<CategoryApiModel> =
        categoryApiDatasource.getCategories()

}