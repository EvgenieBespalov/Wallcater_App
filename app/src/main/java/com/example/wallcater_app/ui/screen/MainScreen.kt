package com.example.wallcater_app.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.bottom_bar.BottomBar
import com.example.wallcater_app.navigation.ListOfBottomMenuItems
import com.example.wallcater_app.navigation.ModulesNavHostContainer
import com.example.wallcater_app.ui.presentation.MainScreenUiState
import com.example.wallcater_app.ui.presentation.MainScreenViewModel
import com.example.wallcater_app.ui.theme.Wallcater_AppTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = koinViewModel()
){
    val state by viewModel.state.observeAsState(MainScreenUiState.Initial)

    when(state){
        MainScreenUiState.Initial    -> viewModel.getTheme()
        MainScreenUiState.Loading    -> LoadScreen()
        is MainScreenUiState.Content -> {
            val darkTheme = remember {
                mutableStateOf((state as MainScreenUiState.Content).theme)
            }

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
        is MainScreenUiState.Error   -> ErrorScreen(errorText = (state as MainScreenUiState.Error).message.orEmpty())
    }
}

@Composable
internal fun ErrorScreen(errorText: String){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Text(text = errorText)
    }
}

@Composable
internal fun LoadScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        CircularProgressIndicator()
    }
}