package com.example.jobs.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable


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
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = ColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        content = content
    )
}