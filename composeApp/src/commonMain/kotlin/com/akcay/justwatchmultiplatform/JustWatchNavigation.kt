package com.akcay.justwatchmultiplatform

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.akcay.justwatchmultiplatform.navigation.HomeScaffold
import com.akcay.justwatchmultiplatform.navigation.Navigable
import com.akcay.justwatchmultiplatform.navigation.NavigableGraphs
import com.akcay.justwatchmultiplatform.navigation.PreviousScreen
import com.akcay.justwatchmultiplatform.navigation.navgraphs.loginScreenNavGraph

@Composable
fun JustWatchNavigation(
    startDestination: Navigable,
) {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier.fillMaxSize(),
        startDestination = startDestination,
        navController = navController,
    ) {
        composable<NavigableGraphs.Home> {
            HomeScaffold(onNavigateTo = { destination, optionsBuilder ->
                navController.navigateTo(destination, navOptions(optionsBuilder))
            })
        }
        loginScreenNavGraph(navController = navController)
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