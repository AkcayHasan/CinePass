package com.akcay.justwatchmultiplatform.domain.mapper

import com.akcay.justwatchmultiplatform.data.model.MovieResponse
import com.akcay.justwatchmultiplatform.domain.model.MovieEntity

fun MovieResponse.toMovieEntity() = MovieEntity(
    id = this.id,
    title = this.title,
    overview = this.overview,
    releaseDate = this.releaseDate,
    posterPath = this.posterPath,
    backdropPath = this.backdropPath,
    voteAverage = this.voteAverage,
    voteCount = this.voteCount,
    popularity = this.popularity,
)