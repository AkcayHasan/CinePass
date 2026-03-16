package com.akcay.cinepass.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.akcay.cinepass.navigation.navgraphs.homeScreenNavGraph
import cinepass.composeapp.generated.resources.Res
import cinepass.composeapp.generated.resources.ic_home
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScaffold(
    onNavigateTo: OnNavigateTo,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination

    val currentScreen = BottomNavigationItem.entries.find {
        currentDestination?.hasRoute(it.routes::class) == true
    } ?: BottomNavigationItem.MOVIES

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier.fillMaxWidth().height(120.dp),
                containerColor = Color.Black,
            ) {
                BottomNavigationItem.entries.forEach { item ->
                    NavigationBarItem(
                        selected = item == currentScreen,
                        icon = {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = item.title,
                                tint = Color.White,
                            )
                        },
                        onClick = {
                            navController.navigate(item.routes) {
                                popUpTo(navController.graph.id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = {
                            Text(
                                text = item.title,
                            )
                        }
                    )
                }
            }
        }
    ) {
        NavHost(
            modifier = modifier.fillMaxSize(),
            navController = navController,
            startDestination = NavigableRoutes.Home.MoviesScreen,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            homeScreenNavGraph(
                onNavigateTo = onNavigateTo,
                navController = navController,
            )
        }
    }
}

@Serializable
enum class BottomNavigationItem(val title: String, val icon: DrawableResource, val routes: NavigableRoutes) {
    MOVIES("Movies", Res.drawable.ic_home, NavigableRoutes.Home.MoviesScreen),
    SEARCH("Search", Res.drawable.ic_home, NavigableRoutes.Home.SearchScreen),
    PROFILE("Profile", Res.drawable.ic_home, NavigableRoutes.Home.ProfileScreen),
}