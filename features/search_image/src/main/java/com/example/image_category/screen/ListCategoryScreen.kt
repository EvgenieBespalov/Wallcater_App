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
import androidx.navigation.NavHostController
import com.example.image_category.domain.entities.CategoryEntity
import com.example.image_category.navigation.SearchImageModuleRoutes
import com.example.image_category.presentation.ListCategoryScreenUiState
import com.example.image_category.presentation.ListCategoryScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun ListCategoryScreen(
    viewModel: ListCategoryScreenViewModel = koinViewModel(),
    navController: NavHostController
){
    val state by viewModel.state.observeAsState(ListCategoryScreenUiState.Initial)

    when(state){
        ListCategoryScreenUiState.Initial    -> viewModel.getListCategories()
        ListCategoryScreenUiState.Loading    -> LoadScreen()
        is ListCategoryScreenUiState.Content -> {
            CategoryList(
                listCategory = (state as ListCategoryScreenUiState.Content).listCategory,
                navController = navController
            )
        }
        is ListCategoryScreenUiState.Error   -> ErrorScreen(errorText = (state as ListCategoryScreenUiState.Error).message.orEmpty())
    }
}



@Composable
fun CategoryList(
    listCategory: List<CategoryEntity>,
    navController: NavHostController
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        items(
            count = listCategory.size
        ){
            CategoryItem(
                category = listCategory[it],
                navController = navController
            )
        }
    }
}

@Composable
fun CategoryItem(
    category: CategoryEntity,
    navController: NavHostController
){
    Button(
        onClick = {
            navController.navigate(SearchImageModuleRoutes.ListImageScreenRoute.route + "/${category.id}")
        },
        modifier = Modifier
            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .height(50.dp)

    ){
        Text(category.name)
    }
}