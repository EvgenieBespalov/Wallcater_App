package com.example.settings.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.settings.presentation.SettingsScreenUiState
import com.example.settings.presentation.SettingsScreenViewModel
import com.example.settings.screen.common.ErrorScreen
import com.example.settings.screen.common.LoadScreen
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun SettingsScreen(
    navController: NavHostController,
    darkTheme: MutableState<Boolean>,
    viewModel: SettingsScreenViewModel = koinViewModel()
){
    val state by viewModel.state.observeAsState(SettingsScreenUiState.Initial)

    when(state){
        SettingsScreenUiState.Initial    -> viewModel.getTheme()
        SettingsScreenUiState.Loading    -> LoadScreen()
        is SettingsScreenUiState.Content -> {
            SettingsList(
                isDarkTheme = (state as SettingsScreenUiState.Content).theme,
                darkTheme = darkTheme
            )
        }
        is SettingsScreenUiState.Error   -> ErrorScreen(errorText = (state as SettingsScreenUiState.Error).message.orEmpty())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SettingsList(
    isDarkTheme: Boolean,
    darkTheme: MutableState<Boolean>,
    viewModel: SettingsScreenViewModel = koinViewModel()
){
    darkTheme.value = isDarkTheme

    Column(
        modifier = Modifier
            .selectableGroup()
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    viewModel.changeTheme(true)
                    //darkTheme.value = true
                },
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(
                selected = isDarkTheme == true,
                onClick = {},
                modifier = Modifier.padding(0.dp)
            )
            Text("Dark theme", fontSize = 20.sp)
        }
        Row(
            modifier = Modifier
                .clickable {
                    viewModel.changeTheme(false)
                    //darkTheme.value = false
                },
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(
                selected = isDarkTheme == false,
                onClick = {},
                modifier = Modifier.padding(0.dp)
            )
            Text("Light theme", fontSize = 20.sp)
        }
    }
}