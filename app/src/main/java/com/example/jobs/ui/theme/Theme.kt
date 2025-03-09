package com.example.jobs.ui.theme


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val ColorScheme = darkColorScheme(
    primary = DarkBlue,
    onPrimary = White,
    background = Black,
    onBackground = White,
    surface = Grey2,
    onSurface = White,
    secondary = Green,
    onSecondary = White,
    tertiary = DarkGreen,
    onTertiary = White,
    inversePrimary = Grey3,
    onSecondaryContainer = Blue,
    error = Red,
    outline = Grey4
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val colors = ColorScheme
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Black,
            darkIcons = false
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        content = content
    )
}