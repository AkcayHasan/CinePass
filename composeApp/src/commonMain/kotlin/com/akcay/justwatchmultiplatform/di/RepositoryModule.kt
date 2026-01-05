package com.akcay.justwatchmultiplatform.di

import com.akcay.justwatchmultiplatform.data.movies.MovieRepositoryImpl
import com.akcay.justwatchmultiplatform.domain.movies.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}