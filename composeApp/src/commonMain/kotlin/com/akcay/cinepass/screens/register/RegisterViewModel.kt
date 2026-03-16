package com.akcay.cinepass.screens.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akcay.cinepass.core.ext.EventDelegate
import com.akcay.cinepass.core.ext.execute
import com.akcay.cinepass.core.onFailure
import com.akcay.cinepass.core.onSuccess
import com.akcay.cinepass.domain.usecase.SignUpUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val signUpUseCase: SignUpUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState = _uiState.asStateFlow()

    private val eventDelegate = EventDelegate<RegisterViewModelEvent>()
    val events = eventDelegate.events

    fun onEmailChanged(email: String) {
        _uiState.update { it.copy(email = email, errorMessage = null) }
    }

    fun onPasswordChanged(password: String) {
        _uiState.update { it.copy(password = password, errorMessage = null) }
    }

    fun onConfirmPasswordChanged(confirmPassword: String) {
        _uiState.update { it.copy(confirmPassword = confirmPassword, errorMessage = null) }
    }

    fun onSignUpClick() {
        val state = _uiState.value
        if (state.password != state.confirmPassword) {
            _uiState.update { it.copy(errorMessage = "Passwords do not match") }
            return
        }
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            execute { signUpUseCase(state.email, state.password) }
                .onSuccess {
                    eventDelegate.trySend(RegisterViewModelEvent.NavigateToHome)
                }
                .onFailure { error ->
                    _uiState.update { it.copy(errorMessage = error.displayMessage) }
                }
            _uiState.update { it.copy(isLoading = false) }
        }
    }
}
