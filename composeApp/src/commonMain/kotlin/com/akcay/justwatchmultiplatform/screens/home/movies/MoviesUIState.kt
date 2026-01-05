package com.akcay.justwatchmultiplatform.screens.home.movies

import com.akcay.justwatchmultiplatform.domain.model.MovieEntity

data class MoviesUIState(
    val items: List<MovieEntity> = emptyList(),
)

