package com.akcay.justwatchmultiplatform.screens.login

data class LoginUiState(
    val email: String = "",
    val password: String = "",
)

sealed interface LoginViewModelEvent {
    object NavigateToHome : LoginViewModelEvent
}
