package com.akcay.cinepass

import androidx.compose.ui.window.ComposeUIViewController
import com.akcay.cinepass.di.appModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController {
    startKoin {
        modules(appModule)
    }

    App()
}