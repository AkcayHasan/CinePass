package com.akcay.justwatchmultiplatform

import androidx.compose.runtime.Composable
import com.akcay.justwatchmultiplatform.navigation.NavigableGraphs
import com.akcay.justwatchmultiplatform.theming.JWTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    JWTheme {
        JustWatchNavigation(startDestination = NavigableGraphs.Login)
    }
}