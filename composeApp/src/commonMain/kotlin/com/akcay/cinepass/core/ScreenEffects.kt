package com.akcay.cinepass.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.akcay.cinepass.components.ProgressIndicator
import com.akcay.cinepass.core.ext.errorMessage
import com.akcay.cinepass.core.ext.progress

@Composable
fun ScreenEffects(
    modifier: Modifier = Modifier,
    viewModel: ViewModel
) {
    val progress by viewModel.progress
    ProgressIndicator(visible = progress)

    val error by viewModel.errorMessage.collectAsStateWithLifecycle(initialValue = null)
    error?.let {

    }


}