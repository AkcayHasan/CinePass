package com.akcay.justwatchmultiplatform.theming

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

@Composable
fun JWTheme(
    shapes: Shapes = Shapes(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        content = content,
        typography = Typography,
        colorScheme = createColors(),
        shapes = shapes,
    )
}

private fun createColors(): ColorScheme = darkColorScheme(
    background = Brand.Background,
)