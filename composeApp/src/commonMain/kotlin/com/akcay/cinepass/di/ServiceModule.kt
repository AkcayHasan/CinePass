package com.akcay.cinepass.di

import com.akcay.cinepass.data.movies.MoviesService
import org.koin.dsl.module

val serviceModule = module {
    single { MoviesService(get()) }
}