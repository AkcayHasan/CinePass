package com.akcay.cinepass.navigation.navgraphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.akcay.cinepass.navigation.NavigableRoutes
import com.akcay.cinepass.navigation.OnNavigateTo
import com.akcay.cinepass.screens.home.movies.MoviesScreen
import com.akcay.cinepass.screens.home.profile.ProfileScreen

fun NavGraphBuilder.homeScreenNavGraph(
    onNavigateTo: OnNavigateTo,
    navController: NavController,
) {
    composable<NavigableRoutes.Home.MoviesScreen> {
        MoviesScreen()
    }
    composable<NavigableRoutes.Home.SearchScreen> {

    }
    composable<NavigableRoutes.Home.ProfileScreen> {
        ProfileScreen()
    }
}