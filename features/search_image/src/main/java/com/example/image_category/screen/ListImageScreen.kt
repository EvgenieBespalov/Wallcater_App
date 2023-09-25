package com.example.image_category.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.image_category.domain.entities.ImageEntity
import com.example.image_category.navigation.SearchImageModuleRoutes
import com.example.image_category.presentation.ListImageScreenUiState
import com.example.image_category.presentation.ListImageScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun ListImageScreen(
    navController: NavHostController,
    categoryId: String,
    viewModel: ListImageScreenViewModel = koinViewModel()
){
    val state by viewModel.state.observeAsState(ListImageScreenUiState.Initial)

    when(state){
        ListImageScreenUiState.Initial    -> viewModel.getListImages(categoryId)
        ListImageScreenUiState.Loading    -> LoadScreen()
        is ListImageScreenUiState.Content -> {
            ListImagesColumn(
                navController = navController,
                images = (state as ListImageScreenUiState.Content).listImage.collectAsLazyPagingItems()
            )
        }
        is ListImageScreenUiState.Error   -> ErrorScreen(errorText = (state as ListImageScreenUiState.Error).message.orEmpty())
    }
}

@Composable
fun ListImagesColumn(
    navController: NavHostController,
    images: LazyPagingItems<ImageEntity>
){
    LazyColumn(){
        items(
            count = images.itemCount
        ){
            images[it]?.let { index ->
                ImageBox(
                    navController = navController,
                    image = index
                )
            }
        }
    }
}

@Composable
fun ImageBox(
    navController: NavHostController,
    image: ImageEntity
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ){
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    navController.navigate(SearchImageModuleRoutes.ImageScreenRoute.route + "/${image.id}")
                },
            model = image.url,
            contentScale = ContentScale.Crop,
            contentDescription = "Icon planet"
        )
    }
}