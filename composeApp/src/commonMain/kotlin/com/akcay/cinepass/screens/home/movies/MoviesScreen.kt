package com.akcay.cinepass.screens.home.movies

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.akcay.cinepass.theming.JWTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.load()
    }

    MoviesScreenContent(state)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreenContent(
    state: MoviesUIState,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    "Movies",
                    style = MaterialTheme.typography.bodyLarge
                )
            })
        }
    ) {

    }

}

@Composable
@Preview
fun MoviesScreenPreview() {
    JWTheme { MoviesScreenContent(state = MoviesUIState()) }
}