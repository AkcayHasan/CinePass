package com.akcay.justwatchmultiplatform

import androidx.compose.ui.window.ComposeUIViewController
import com.akcay.justwatchmultiplatform.di.appModule
import com.akcay.justwatchmultiplatform.di.viewModelModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController {
    startKoin {
        modules(appModule)
    }

    App()
}