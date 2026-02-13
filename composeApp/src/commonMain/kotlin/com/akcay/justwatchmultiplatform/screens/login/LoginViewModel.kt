package com.akcay.justwatchmultiplatform.screens.login

import androidx.lifecycle.ViewModel
import com.akcay.justwatchmultiplatform.core.ext.EventDelegate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel(

): ViewModel() {
    val uiState = MutableStateFlow(LoginUiState())

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
}