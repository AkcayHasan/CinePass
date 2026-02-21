package com.akcay.cinepass.di

import com.akcay.cinepass.data.movies.MovieRepositoryImpl
import com.akcay.cinepass.domain.movies.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}