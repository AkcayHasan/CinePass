package com.akcay.justwatchmultiplatform.di

import com.akcay.justwatchmultiplatform.screens.home.movies.MoviesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::MoviesViewModel)
}
