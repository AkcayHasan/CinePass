package com.akcay.cinepass.screens.register

data class RegisterUiState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)

sealed interface RegisterViewModelEvent {
    data object NavigateToHome : RegisterViewModelEvent
}