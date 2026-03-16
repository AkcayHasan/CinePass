package com.akcay.cinepass.di

import com.akcay.cinepass.data.auth.AuthRepositoryImpl
import com.akcay.cinepass.data.auth.FirebaseAuthService
import com.akcay.cinepass.domain.auth.AuthRepository
import com.akcay.cinepass.domain.usecase.SignInUseCase
import com.akcay.cinepass.domain.usecase.SignUpUseCase
import org.koin.dsl.module

val authModule = module {
    single { FirebaseAuthService() }
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    factory { SignInUseCase(get()) }
    factory { SignUpUseCase(get()) }
}
