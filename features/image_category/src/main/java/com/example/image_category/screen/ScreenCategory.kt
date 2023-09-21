package com.example.image_category.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScreenCategory(){
    CategoryList()
}

@Composable
fun CategoryList(){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        items(
            count = 10
        ){
            CategoryItem(it)
        }
    }
}

@Composable
fun CategoryItem(
    number: Int
){
    Button(
        onClick = {},
        modifier = Modifier
            .size(100.dp, 30.dp)
    ){
        Text("Category №${number}")
    }
}

@Composable
@Preview
fun ScreenCategoryPreview(){
    ScreenCategory()
}