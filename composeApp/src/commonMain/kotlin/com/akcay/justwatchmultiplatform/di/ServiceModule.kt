package com.akcay.justwatchmultiplatform.di

import com.akcay.justwatchmultiplatform.data.movies.MoviesService
import org.koin.dsl.module

val serviceModule = module {
    single { MoviesService(get()) }
}