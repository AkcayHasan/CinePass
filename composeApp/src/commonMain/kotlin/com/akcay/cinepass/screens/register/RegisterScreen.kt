package com.akcay.cinepass.screens.register

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
import justwatchmultiplatform.composeapp.generated.resources.Res
import justwatchmultiplatform.composeapp.generated.resources.ic_google
import justwatchmultiplatform.composeapp.generated.resources.ic_logo
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = koinViewModel(),
    onSignUpClick: () -> Unit,
    onSignInWithGoogleClick: () -> Unit,
    onSignInClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onGuestClick: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    RegisterScreenContent(
        uiState = uiState,
        onEmailChange = viewModel::onEmailChanged,
        onPasswordChange = viewModel::onPasswordChanged,
        onConfirmPasswordChange = viewModel::onConfirmPasswordChanged,
        onSignUpClick = onSignUpClick,
        onSignInWithGoogleClick = onSignInWithGoogleClick,
        onSignInClick = onSignInClick,
        onForgotPasswordClick = onForgotPasswordClick,
        onGuestClick = onGuestClick,
    )
}

@Composable
fun RegisterScreenContent(
    uiState: RegisterUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
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
                text = "Sign Up",
                style = MaterialTheme.typography.bodyLarge.copy(color = TextColors.Accent),
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 30.dp),
                text = "Create your account to start exploring trailers.",
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
            JWPasswordTextField(
                modifier = Modifier.padding(top = 14.dp),
                value = uiState.password,
                label = "Confirm Password",
                onValueChange = onPasswordChange,
            )
            NavigateButtons(
                modifier = Modifier.padding(top = 20.dp),
                onSignUpClick = onSignUpClick,
                onSignInWithGoogleClick = {},
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.padding(top = 20.dp),
            ) {
                Text(
                    modifier = Modifier.padding(end = 10.dp),
                    text = "Already have an account?",
                    style = MaterialTheme.typography.bodyMedium,
                )
                JWTextButton(
                    modifier = Modifier
                        .padding(start = 4.dp),
                    text = "Log In",
                    onClick = onSignInClick,
                )
            }
            JWTextButton(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 50.dp),
                text = "Login as Guest",
                onClick = onGuestClick,
            )
        }
    }
}

@Composable
private fun NavigateButtons(
    modifier: Modifier = Modifier,
    onSignUpClick: () -> Unit,
    onSignInWithGoogleClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        JWPrimaryButton(
            modifier = Modifier.height(56.dp),
            text = "Sign Up",
            onClick = onSignUpClick,
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
fun RegisterScreenPreview(
    modifier: Modifier = Modifier,
) {
    JWTheme {
        RegisterScreenContent(
            uiState = RegisterUiState(),
            onEmailChange = {},
            onPasswordChange = {},
            onConfirmPasswordChange = {},
        )
    }
}