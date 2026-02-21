package com.akcay.cinepass.screens.register

import androidx.lifecycle.ViewModel
import com.akcay.cinepass.core.ext.EventDelegate
import com.akcay.cinepass.screens.login.LoginViewModelEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel(

): ViewModel() {
    val uiState = MutableStateFlow(RegisterUiState())

    private val eventDelegate = EventDelegate<LoginViewModelEvent>()
    val events = eventDelegate.events

    fun onEvent(event: LoginViewModelEvent) {
        eventDelegate.trySend(event)
    }

    fun onEmailChanged(email: String) {
        uiState.update { it.copy(email = email) }
    }
    fun onPasswordChanged(password: String) {
        uiState.update { it.copy(password = password) }
    }
    fun onConfirmPasswordChanged(password: String) {
        uiState.update { it.copy(password = password) }
    }
}