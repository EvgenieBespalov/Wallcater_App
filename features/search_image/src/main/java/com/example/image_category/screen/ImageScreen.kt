package com.example.image_category.screen

import android.app.WallpaperManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.image_category.domain.entities.ImageEntity
import com.example.image_category.navigation.SearchImageModuleRoutes
import com.example.image_category.presentation.ImageScreenUiState
import com.example.image_category.presentation.ImageScreenViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun ImageScreen(
    viewModel: ImageScreenViewModel = koinViewModel(),
    imageId: String
){
    val state by viewModel.state.observeAsState(ImageScreenUiState.Initial)

    when(state){
        ImageScreenUiState.Initial    -> viewModel.getImageById(imageId)
        ImageScreenUiState.Loading    -> LoadScreen()
        is ImageScreenUiState.Content -> {
            ImageColumn(
                image = (state as ImageScreenUiState.Content).image,
                checkSaveInDatabase = (state as ImageScreenUiState.Content).checkSaveInDatabase,
            )
        }
        is ImageScreenUiState.Error   -> ErrorScreen(errorText = (state as ImageScreenUiState.Error).message.orEmpty())
    }
}

@Composable
internal fun ImageColumn(
    image: ImageEntity,
    checkSaveInDatabase: Boolean,
    viewModel: ImageScreenViewModel = koinViewModel(),
){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxSize(),
            model = image.url,
            contentScale = ContentScale.Crop,
            contentDescription = "Icon planet"
        )

        Button(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            onClick = {
                viewModel.setWallpapperOnSystemScreen(image.url)
            }
        ) {
            Text(
                text = "Set wallpaper to the system screen"
            )
        }

        Button(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            onClick = {
                viewModel.setWallpapperOnLockScreen(image.url)
            }
        ) {
            Text(
                text = "Set wallpaper to the lock screen"
            )
        }

        Button(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            onClick = {
                when(checkSaveInDatabase){
                    false -> viewModel.saveImageInDatabase(image)
                    true -> viewModel.deleteImageInDatabase(image)
                }
            },
        ) {
            Text(
                text = when(checkSaveInDatabase){
                    false -> "Add to Favorites"
                    true -> "Delete from Favorites"
                }

            )
        }

        /*Button(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Save to Phone"
            )
        }*/
    }
}

