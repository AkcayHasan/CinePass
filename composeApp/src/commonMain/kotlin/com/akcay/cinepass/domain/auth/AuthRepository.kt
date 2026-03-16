package com.akcay.cinepass.domain.auth

import com.akcay.cinepass.core.ApiResult
import com.akcay.cinepass.core.ErrorResponse
import com.akcay.cinepass.domain.model.AuthUser

interface AuthRepository {
    suspend fun signIn(email: String, password: String): ApiResult<AuthUser, ErrorResponse>
    suspend fun signUp(email: String, password: String): ApiResult<AuthUser, ErrorResponse>
    fun signOut()
    fun currentUserId(): String?
}
