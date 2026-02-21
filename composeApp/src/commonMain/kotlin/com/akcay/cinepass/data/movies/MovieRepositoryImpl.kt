package com.akcay.cinepass.data.movies

import com.akcay.cinepass.core.ApiResult
import com.akcay.cinepass.core.ErrorResponse
import com.akcay.cinepass.domain.mapper.toMovieEntity
import com.akcay.cinepass.domain.model.MovieEntity
import com.akcay.cinepass.domain.movies.MovieRepository

class MovieRepositoryImpl(private val service: MoviesService) : MovieRepository {

    override suspend fun fetchMovies(): ApiResult<List<MovieEntity>, ErrorResponse> =
        service.getPopularMovies().map { response ->
            response.data.map { it.toMovieEntity() }
        }
}