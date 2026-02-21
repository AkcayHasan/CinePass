package com.akcay.cinepass.navigation

import kotlinx.serialization.Serializable

sealed class NavigableGraphs: Navigable {
    @Serializable
    data object Home: NavigableGraphs()
    @Serializable
    data object Login: NavigableGraphs()
}