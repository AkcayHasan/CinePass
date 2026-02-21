package com.akcay.cinepass.navigation

import kotlinx.serialization.Serializable

interface Navigable

@Serializable data object PreviousScreen : Navigable