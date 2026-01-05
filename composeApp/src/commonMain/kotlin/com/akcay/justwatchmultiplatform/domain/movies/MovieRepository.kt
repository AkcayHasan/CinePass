package com.akcay.justwatchmultiplatform.domain.movies

import com.akcay.justwatchmultiplatform.core.ApiResult
import com.akcay.justwatchmultiplatform.core.ErrorResponse
import com.akcay.justwatchmultiplatform.core.PageData
import com.akcay.justwatchmultiplatform.domain.model.MovieEntity

interface MovieRepository {
    suspend fun fetchMovies(): ApiResult<List<MovieEntity>, ErrorResponse>
}