package com.akcay.cinepass.data.auth

import cocoapods.FirebaseAuth.FIRAuth
import cocoapods.FirebaseAuth.FIRUser
import com.akcay.cinepass.domain.model.AuthUser
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

@OptIn(ExperimentalForeignApi::class)
actual class FirebaseAuthService {
    private val auth = FIRAuth.auth()

    actual suspend fun signIn(email: String, password: String): AuthUser =
        suspendCancellableCoroutine { cont ->
            auth.signInWithEmail(email, password = password) { dataResult, error ->
                if (error != null) {
                    cont.resumeWithException(Exception(error.localizedDescription))
                } else {
                    val user = dataResult?.user()
                        ?: return@signInWithEmail cont.resumeWithException(Exception("Authentication failed: user is null"))
                    cont.resume(
                        AuthUser(
                            id = user.uid(),
                            name = user.displayName() ?: "",
                            email = user.email() ?: "",
                        )
                    )
                }
            }
        }

    actual suspend fun signUp(email: String, password: String): AuthUser =
        suspendCancellableCoroutine { cont ->
            auth.createUserWithEmail(email, password = password) { dataResult, error ->
                if (error != null) {
                    cont.resumeWithException(Exception(error.localizedDescription))
                } else {
                    val user = dataResult?.user()
                        ?: return@createUserWithEmail cont.resumeWithException(Exception("Registration failed: user is null"))
                    cont.resume(
                        AuthUser(
                            id = user.uid(),
                            name = user.displayName() ?: "",
                            email = user.email() ?: "",
                        )
                    )
                }
            }
        }

    actual fun signOut() {
        auth.signOut(null)
    }

    actual fun currentUserId(): String? {
        val user: FIRUser? = auth.currentUser()
        return user?.uid()
    }
}
