package com.akcay.cinepass.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akcay.cinepass.core.ext.EventDelegate
import com.akcay.cinepass.core.ext.execute
import com.akcay.cinepass.core.onFailure
import com.akcay.cinepass.core.onSuccess
import com.akcay.cinepass.domain.usecase.SignInUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val signInUseCase: SignInUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    private val eventDelegate = EventDelegate<LoginViewModelEvent>()
    val events = eventDelegate.events

    fun onEmailChanged(email: String) {
        _uiState.update { it.copy(email = email, errorMessage = null) }
    }

    fun onPasswordChanged(password: String) {
        _uiState.update { it.copy(password = password, errorMessage = null) }
    }

    fun onSignInClick() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            execute { signInUseCase(_uiState.value.email, _uiState.value.password) }
                .onSuccess {
                    eventDelegate.trySend(LoginViewModelEvent.NavigateToHome)
                }
                .onFailure { error ->
                    _uiState.update { it.copy(errorMessage = error.displayMessage) }
                }
            _uiState.update { it.copy(isLoading = false) }
        }
    }
}
