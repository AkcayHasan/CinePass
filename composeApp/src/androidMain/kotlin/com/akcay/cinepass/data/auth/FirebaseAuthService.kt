package com.akcay.cinepass.data.auth

import com.akcay.cinepass.domain.model.AuthUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

actual class FirebaseAuthService {
    private val auth = Firebase.auth

    actual suspend fun signIn(email: String, password: String): AuthUser {
        val result = auth.signInWithEmailAndPassword(email, password).await()
        val user = result.user ?: throw Exception("Authentication failed: user is null")
        return AuthUser(
            id = user.uid,
            name = user.displayName.orEmpty(),
            email = user.email.orEmpty(),
        )
    }

    actual suspend fun signUp(email: String, password: String): AuthUser {
        val result = auth.createUserWithEmailAndPassword(email, password).await()
        val user = result.user ?: throw Exception("Registration failed: user is null")
        return AuthUser(
            id = user.uid,
            name = user.displayName.orEmpty(),
            email = user.email.orEmpty(),
        )
    }

    actual fun signOut() = auth.signOut()

    actual fun currentUserId(): String? = auth.currentUser?.uid
}