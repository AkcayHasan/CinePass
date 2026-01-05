package com.akcay.justwatchmultiplatform.data.movies

import com.akcay.justwatchmultiplatform.core.ApiResult
import com.akcay.justwatchmultiplatform.core.ErrorResponse
import com.akcay.justwatchmultiplatform.core.PageData
import com.akcay.justwatchmultiplatform.domain.mapper.toMovieEntity
import com.akcay.justwatchmultiplatform.domain.model.MovieEntity
import com.akcay.justwatchmultiplatform.domain.movies.MovieRepository

class MovieRepositoryImpl(private val service: MoviesService) : MovieRepository {

    override suspend fun fetchMovies(): ApiResult<List<MovieEntity>, ErrorResponse> =
        service.getPopularMovies().map { response ->
            response.data.map { it.toMovieEntity() }
        }
}