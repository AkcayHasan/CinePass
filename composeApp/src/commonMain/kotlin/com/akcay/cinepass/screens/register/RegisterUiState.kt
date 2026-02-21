package com.akcay.cinepass.screens.register

data class RegisterUiState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
)

sealed interface RegisterViewModelEvent {
    object NavigateToHome : RegisterViewModelEvent
}