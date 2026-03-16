package com.akcay.cinepass.domain.usecase

import com.akcay.cinepass.core.ApiResult
import com.akcay.cinepass.core.ErrorResponse
import com.akcay.cinepass.domain.auth.AuthRepository
import com.akcay.cinepass.domain.model.AuthUser

class SignInUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(
        email: String,
        password: String,
    ): ApiResult<AuthUser, ErrorResponse> = repository.signIn(email, password)
}
