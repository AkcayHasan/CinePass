package com.akcay.cinepass.screens.home.movies

import com.akcay.cinepass.domain.model.MovieEntity

data class MoviesUIState(
    val items: List<MovieEntity> = emptyList(),
)

