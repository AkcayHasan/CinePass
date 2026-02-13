package com.akcay.justwatchmultiplatform.navigation.navgraphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.akcay.justwatchmultiplatform.navigation.NavigableGraphs
import com.akcay.justwatchmultiplatform.navigation.NavigableRoutes
import com.akcay.justwatchmultiplatform.screens.login.LoginScreen

fun NavGraphBuilder.loginScreenNavGraph(navController: NavController) {
    navigation<NavigableGraphs.Login>(
        startDestination = NavigableRoutes.Login.LoginScreen
    ) {
        composable<NavigableRoutes.Login.LoginScreen> {
            LoginScreen(
                onSignUpClick = {},
                onSignInWithGoogleClick = {},
                onSignInClick = {},
                onForgotPasswordClick = {},
                onGuestClick = {},
            )
        }
        composable<NavigableRoutes.Login.RegisterScreen> {

        }
        composable<NavigableRoutes.Login.ForgotPassword> {

        }
    }
}