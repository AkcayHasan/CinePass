package com.akcay.cinepass.di

import com.akcay.cinepass.screens.home.movies.MoviesViewModel
import com.akcay.cinepass.screens.login.LoginViewModel
import com.akcay.cinepass.screens.register.RegisterViewModel
import com.akcay.cinepass.screens.splash.SplashViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::MoviesViewModel)
    viewModelOf(::SplashViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::RegisterViewModel)
}
