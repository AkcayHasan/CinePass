package com.akcay.cinepass.data.auth

import com.akcay.cinepass.core.ApiResult
import com.akcay.cinepass.core.ErrorResponse
import com.akcay.cinepass.domain.auth.AuthRepository
import com.akcay.cinepass.domain.model.AuthUser

class AuthRepositoryImpl(private val authService: FirebaseAuthService) : AuthRepository {

    override suspend fun signIn(email: String, password: String): ApiResult<AuthUser, ErrorResponse> =
        try {
            ApiResult.Success(authService.signIn(email, password))
        } catch (e: Exception) {
            ApiResult.Failure(ErrorResponse(statusMessage = e.message ?: "Sign in failed"))
        }

    override suspend fun signUp(email: String, password: String): ApiResult<AuthUser, ErrorResponse> =
        try {
            ApiResult.Success(authService.signUp(email, password))
        } catch (e: Exception) {
            ApiResult.Failure(ErrorResponse(statusMessage = e.message ?: "Sign up failed"))
        }

    override fun signOut() = authService.signOut()

    override fun currentUserId(): String? = authService.currentUserId()
}
