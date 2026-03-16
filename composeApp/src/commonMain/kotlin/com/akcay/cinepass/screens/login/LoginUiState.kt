package com.akcay.cinepass.screens.login

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)

sealed interface LoginViewModelEvent {
    data object NavigateToHome : LoginViewModelEvent
}
