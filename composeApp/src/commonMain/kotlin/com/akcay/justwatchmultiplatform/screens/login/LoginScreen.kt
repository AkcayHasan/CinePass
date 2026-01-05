package com.akcay.justwatchmultiplatform.screens.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.akcay.justwatchmultiplatform.theming.JWTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen() {
    Scaffold {
        LoginScreenContent()
    }
}

@Composable
private fun LoginScreenContent() {
    Scaffold {

    }
}

@Composable
@Preview
private fun LoginScreenPreview() {
    JWTheme {
        LoginScreenContent()
    }
}
