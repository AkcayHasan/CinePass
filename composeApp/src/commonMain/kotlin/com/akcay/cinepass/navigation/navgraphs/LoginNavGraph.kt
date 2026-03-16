package com.akcay.cinepass.navigation.navgraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.akcay.cinepass.navigation.NavigableGraphs
import com.akcay.cinepass.navigation.NavigableRoutes
import com.akcay.cinepass.navigation.OnNavigateTo
import com.akcay.cinepass.screens.login.LoginScreen
import com.akcay.cinepass.screens.register.RegisterScreen

fun NavGraphBuilder.loginScreenNavGraph(
    onNavigateTo: OnNavigateTo,
    navigateBack: () -> Unit,
) {
    navigation<NavigableGraphs.Login>(
        startDestination = NavigableRoutes.Login.LoginScreen
    ) {
        composable<NavigableRoutes.Login.LoginScreen> {
            LoginScreen(
                onSignUpClick = {
                    onNavigateTo(NavigableRoutes.Login.RegisterScreen, null)
                },
                onSignInWithGoogleClick = {},
                onSignInClick = {
                    onNavigateTo(NavigableGraphs.Home) {
                        popUpTo(NavigableGraphs.Login) { inclusive = true }
                    }
                },
                onForgotPasswordClick = {},
                onGuestClick = {
                    onNavigateTo(NavigableGraphs.Home) {
                        popUpTo(NavigableGraphs.Login) { inclusive = true }
                    }
                },
            )
        }
        composable<NavigableRoutes.Login.RegisterScreen> {
            RegisterScreen(
                navigateHome = {
                    onNavigateTo(NavigableGraphs.Home) {
                        popUpTo(NavigableGraphs.Login) { inclusive = true }
                    }
                },
                onSignInWithGoogleClick = {},
                onSignInClick = navigateBack,
                onForgotPasswordClick = {},
                onGuestClick = {
                    onNavigateTo(NavigableGraphs.Home) {
                        popUpTo(NavigableGraphs.Login) { inclusive = true }
                    }
                },
            )
        }
        composable<NavigableRoutes.Login.ForgotPassword> {

        }
    }
}