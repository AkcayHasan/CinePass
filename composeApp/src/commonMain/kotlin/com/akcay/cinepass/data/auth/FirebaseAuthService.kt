package com.akcay.cinepass.data.auth

import com.akcay.cinepass.domain.model.AuthUser

expect class FirebaseAuthService() {
    suspend fun signIn(email: String, password: String): AuthUser
    suspend fun signUp(email: String, password: String): AuthUser
    fun signOut()
    fun currentUserId(): String?
}