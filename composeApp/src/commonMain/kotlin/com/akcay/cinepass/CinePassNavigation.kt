package com.akcay.cinepass

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.akcay.cinepass.navigation.HomeScaffold
import com.akcay.cinepass.navigation.Navigable
import com.akcay.cinepass.navigation.NavigableGraphs
import com.akcay.cinepass.navigation.NavigableRoutes
import com.akcay.cinepass.navigation.PreviousScreen
import com.akcay.cinepass.navigation.navgraphs.loginScreenNavGraph
import com.akcay.cinepass.screens.genre.GenreScreen

@Composable
fun CinePassNavigation(
    startDestination: Navigable,
) {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier.fillMaxSize(),
        startDestination = startDestination,
        navController = navController,
    ) {
        composable<NavigableGraphs.Home> {
            HomeScaffold(
                onNavigateTo = { destination, optionsBuilder ->
                    navController.navigateTo(
                        destination,
                        optionsBuilder?.let { navOptions(it) })
                })
        }
        loginScreenNavGraph(
            onNavigateTo = { destination, optionsBuilder ->
                navController.navigateTo(
                    destination,
                    optionsBuilder?.let { navOptions(it) })
            },
            navigateBack = { navController.popBackStack() }
        )

        composable<NavigableRoutes.Genre> {
            GenreScreen()
        }
    }
}

internal fun NavController.navigateTo(
    destination: Navigable,
    navOptions: NavOptions? = null,
) {
    when (destination) {
        is PreviousScreen -> {
            val isBackStackEmpty = previousBackStackEntry == null
            if (!isBackStackEmpty) popBackStack()
        }

        else -> navigate(destination, navOptions)
    }
}