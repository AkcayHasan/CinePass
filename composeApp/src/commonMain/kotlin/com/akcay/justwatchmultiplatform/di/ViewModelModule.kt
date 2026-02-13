package com.akcay.justwatchmultiplatform.di

import com.akcay.justwatchmultiplatform.screens.home.movies.MoviesViewModel
import com.akcay.justwatchmultiplatform.screens.login.LoginViewModel
import com.akcay.justwatchmultiplatform.screens.splash.SplashViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::MoviesViewModel)
    viewModelOf(::SplashViewModel)
    viewModelOf(::LoginViewModel)
}
