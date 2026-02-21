package com.akcay.cinepass.navigation

import androidx.navigation.NavOptionsBuilder
import kotlinx.serialization.Serializable

typealias OnNavigateTo = (Navigable, (NavOptionsBuilder.() -> Unit)?) -> Unit

sealed class NavigableRoutes : Navigable {
    sealed class Home : NavigableRoutes() {
        @Serializable
        data object MoviesScreen : Home()
        @Serializable
        data object SearchScreen : Home()
        @Serializable
        data object ProfileScreen : Home()
    }

    sealed class Login : NavigableRoutes() {
        @Serializable
        data object LoginScreen : Login()
        @Serializable
        data object RegisterScreen : Login()
        @Serializable
        data object ForgotPassword : Login()
    }

    @Serializable
    data class MovieDetailScreen(val id: String) : NavigableRoutes()

    @Serializable
    data object Genre : NavigableRoutes()
}