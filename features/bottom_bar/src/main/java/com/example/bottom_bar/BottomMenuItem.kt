package com.example.bottom_bar

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomMenuItem(
    val label: String,
    val icon: ImageVector,
    var route: String
    )
