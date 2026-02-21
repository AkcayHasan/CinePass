package com.akcay.cinepass

import androidx.compose.runtime.Composable
import com.akcay.cinepass.navigation.NavigableGraphs
import com.akcay.cinepass.theming.JWTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    JWTheme {
        CinePassNavigation(startDestination = NavigableGraphs.Login)
    }
}