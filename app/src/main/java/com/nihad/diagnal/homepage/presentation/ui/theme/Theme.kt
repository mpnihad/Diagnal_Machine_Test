package com.plcoding.cleanarchitecturenoteapp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.nihad.diagnal.homepage.presentation.ui.theme.DarkGray
import com.nihad.diagnal.homepage.presentation.ui.theme.LightBlue

private val DarkColorPalette = darkColors(
    primary = Color.White,
    background = DarkGray,
    onBackground = Color.White,
    surface = LightBlue,
    onSurface = DarkGray
)

@Composable
fun CleanArchitectureNoteAppTheme(darkTheme: Boolean = true, content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = appTypography,
        shapes = Shapes,
        content = content
    )
}