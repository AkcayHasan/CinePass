package com.akcay.cinepass.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.akcay.cinepass.components.JWPasswordTextField
import com.akcay.cinepass.components.JWPrimaryButton
import com.akcay.cinepass.components.JWSecondaryButton
import com.akcay.cinepass.components.JWTextButton
import com.akcay.cinepass.components.JWTextField
import com.akcay.cinepass.theming.JWTheme
import com.akcay.cinepass.theming.TextColors
import cinepass.composeapp.generated.resources.Res
import cinepass.composeapp.generated.resources.ic_google
import cinepass.composeapp.generated.resources.ic_logo
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    onSignUpClick: () -> Unit,
    onSignInWithGoogleClick: () -> Unit,
    onSignInClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onGuestClick: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is LoginViewModelEvent.NavigateToHome -> onSignInClick()
            }
        }
    }

    LoginScreenContent(
        uiState = uiState,
        onEmailChange = viewModel::onEmailChanged,
        onPasswordChange = viewModel::onPasswordChanged,
        onSignInClick = viewModel::onSignInClick,
        onSignUpClick = onSignUpClick,
        onSignInWithGoogleClick = onSignInWithGoogleClick,
        onForgotPasswordClick = onForgotPasswordClick,
        onGuestClick = onGuestClick,
    )
}

@Composable
private fun LoginScreenContent(
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onSignUpClick: () -> Unit = {},
    onSignInWithGoogleClick: () -> Unit = {},
    onSignInClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {},
    onGuestClick: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Log In",
                style = MaterialTheme.typography.bodyLarge.copy(color = TextColors.Accent),
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 30.dp),
                text = "Welcome! Please sign in to continue",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )
            Icon(
                painter = painterResource(Res.drawable.ic_logo),
                contentDescription = "JustWatch Logo",
                tint = Color.Unspecified,
            )
            JWTextField(
                modifier = Modifier.padding(top = 20.dp),
                value = uiState.email,
                label = "Email",
                onValueChange = onEmailChange,
            )
            JWPasswordTextField(
                modifier = Modifier.padding(top = 14.dp),
                value = uiState.password,
                label = "Password",
                onValueChange = onPasswordChange,
            )
            if (uiState.errorMessage != null) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    text = uiState.errorMessage,
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.error),
                )
            }
            JWTextButton(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.End),
                text = "Forgot Password?",
                onClick = onForgotPasswordClick,
            )
            NavigateButtons(
                modifier = Modifier.padding(top = 20.dp),
                isLoading = uiState.isLoading,
                onSignInClick = onSignInClick,
                onSignInWithGoogleClick = onSignInWithGoogleClick,
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.padding(top = 20.dp),
            ) {
                Text(
                    modifier = Modifier.padding(end = 10.dp),
                    text = "Don't have an account?",
                    style = MaterialTheme.typography.bodyMedium,
                )
                JWTextButton(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .clickable { onSignUpClick() },
                    text = "Sign Up",
                    onClick = onSignUpClick,
                )
            }
            JWTextButton(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 50.dp)
                    .clickable { onGuestClick() },
                text = "Login as Guest",
                onClick = onGuestClick,
            )
        }
    }
}

@Composable
private fun NavigateButtons(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    onSignInClick: () -> Unit,
    onSignInWithGoogleClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        JWPrimaryButton(
            modifier = Modifier.height(56.dp),
            text = "Sign In",
            isLoading = isLoading,
            onClick = onSignInClick,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            HorizontalDivider(modifier = Modifier.weight(1f), thickness = 1.dp, color = Color.White)
            Text(modifier = Modifier.padding(horizontal = 26.dp), text = "OR", color = Color.White)
            HorizontalDivider(modifier = Modifier.weight(1f), thickness = 1.dp, color = Color.White)
        }
        JWSecondaryButton(
            modifier = Modifier.height(44.dp),
            text = "Continue with Google",
            onClick = onSignInWithGoogleClick,
            trailingIcon = Res.drawable.ic_google,
        )
    }
}

@Composable
@Preview
private fun LoginScreenPreview() {
    JWTheme {
        LoginScreenContent(
            uiState = LoginUiState(),
            onEmailChange = {},
            onPasswordChange = {},
        )
    }
}
