package com.example.wallcater_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.bottom_bar.BottomBar
import com.example.settings.screen.Wallcater_AppTheme
import com.example.wallcater_app.navigation.ListOfBottomMenuItems
import com.example.wallcater_app.navigation.ModulesNavHostContainer

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkTheme = remember { mutableStateOf(true) }

                Wallcater_AppTheme(
                    darkTheme = darkTheme.value,
                    content = {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            val navController = rememberNavController()

                            Scaffold(
                                bottomBar = {
                                    BottomBar(
                                        navController = navController,
                                        bottomMenuItems = ListOfBottomMenuItems.BottomMenuItems
                                    )
                                },
                                content = { padding ->
                                    ModulesNavHostContainer(
                                        navController = navController,
                                        padding = padding,
                                        darkTheme = darkTheme
                                    )
                                }
                            )
                        }
                    }
                )
        }
    }
}
/*
@Composable
fun clickB(
    state: MutableState<Boolean>
){
    Button(onClick = { state.value = !state.value }) {
        Text("Change theme")
    }
}*/