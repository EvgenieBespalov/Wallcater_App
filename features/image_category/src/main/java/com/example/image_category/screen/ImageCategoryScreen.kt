package com.example.image_category.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.image_category.domain.entities.CategoryEntity
import com.example.image_category.presentation.ScreenCategoryUiState
import com.example.image_category.presentation.ScreenCategoryViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenCategory(
    viewModel: ScreenCategoryViewModel = koinViewModel(),
){
    val state by viewModel.state.observeAsState(ScreenCategoryUiState.Initial)

    when(state){
        ScreenCategoryUiState.Initial    -> viewModel.getListCategories()
        ScreenCategoryUiState.Loading    -> LoadScreen()
        is ScreenCategoryUiState.Content -> {
            CategoryList(listCategory = (state as ScreenCategoryUiState.Content).listCategory)
        }
        is ScreenCategoryUiState.Error   -> ErrorScreen(errorText = (state as ScreenCategoryUiState.Error).message.orEmpty())
    }
}

@Composable
fun CategoryList(
    listCategory: List<CategoryEntity>
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        items(
            count = listCategory.size
        ){
            CategoryItem(listCategory[it])
        }
    }
}

@Composable
fun CategoryItem(
    category: CategoryEntity
){
    Button(
        onClick = {},
        modifier = Modifier
            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .height(50.dp)

    ){
        Text(category.name)
    }
}