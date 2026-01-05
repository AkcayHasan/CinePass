package com.akcay.justwatchmultiplatform.domain.model

data class MovieEntity(
    val id: Int,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val posterPath: String?,
    val backdropPath: String?,
    val voteAverage: Double,
    val voteCount: Int,
    val popularity: Double,
)