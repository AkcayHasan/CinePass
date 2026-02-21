package com.akcay.cinepass.domain.movies

import com.akcay.cinepass.core.ApiResult
import com.akcay.cinepass.core.ErrorResponse
import com.akcay.cinepass.domain.model.MovieEntity

interface MovieRepository {
    suspend fun fetchMovies(): ApiResult<List<MovieEntity>, ErrorResponse>
}