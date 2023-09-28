package com.example.settings.screen

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.navigation.NavHostController
import com.example.settings.presentation.SettingsScreenUiState
import com.example.settings.presentation.SettingsScreenViewModel
import com.example.settings.screen.common.ErrorScreen
import com.example.settings.screen.common.LoadScreen
import com.example.settings.screen.theme.DarkColorScheme
import com.example.settings.screen.theme.LightColorScheme
import com.example.settings.screen.theme.TypographyStyle
import org.koin.androidx.compose.koinViewModel

@Composable
fun Wallcater_AppTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit,
){
    AppThemeScreen(
        darkTheme = darkTheme,
        content = content
    )
}



@Composable
internal fun AppThemeScreen(
    content: @Composable () -> Unit,
    darkTheme: Boolean,
    viewModel: SettingsScreenViewModel = koinViewModel()
){
    val state by viewModel.state.observeAsState(SettingsScreenUiState.Initial)


    when(state){
        SettingsScreenUiState.Initial    -> viewModel.getTheme()
        SettingsScreenUiState.Loading    -> LoadScreen()
        is SettingsScreenUiState.Content -> {
            AppTheme(
                isDarkThemeStart = (state as SettingsScreenUiState.Content).theme,
                darkTheme = darkTheme,
                content = content
            )
        }
        is SettingsScreenUiState.Error   -> ErrorScreen(errorText = (state as SettingsScreenUiState.Error).message.orEmpty())
    }
}

@Composable
internal fun AppTheme(
    isDarkThemeStart: Boolean,
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        isDarkThemeStart -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            //ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = TypographyStyle,
        content = content
    )
}

