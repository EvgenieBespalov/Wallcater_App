package com.example.data.api.paging_source

import android.service.controls.ControlsProviderService
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.api.data_source.ImageApiDatasource
import com.example.data.api.model.ImageApiModel
import retrofit2.HttpException

class ImagePagingSource(
    private val imageApiDatasource: ImageApiDatasource,
    private val categoryId: String
): PagingSource<Int, ImageApiModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageApiModel> {
        if (categoryId.isBlank()) {
            return LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
        }
        try {
            val pageNumber = params.key ?: 1
            val response = imageApiDatasource.getListImages(pageNumber.toString(), categoryId)

            if (response.isSuccessful) {
                val images = response.body()!!
                val nextPageNumber = if (images.isEmpty()) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null

                return LoadResult.Page(images, prevPageNumber, nextPageNumber)
            } else {
                Log.i(ControlsProviderService.TAG, "PagingSource Error: " + HttpException(response))
                return LoadResult.Error(HttpException(response))
            }
        } catch (e: HttpException) {
            Log.i(ControlsProviderService.TAG, "PagingSource HttpException: " + e)
            return LoadResult.Error(e)
        } catch (e: Exception) {
            Log.i(ControlsProviderService.TAG, "PagingSource Exception:" + e)
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ImageApiModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }
}