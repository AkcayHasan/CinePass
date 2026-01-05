package com.akcay.justwatchmultiplatform.data.movies

import com.akcay.justwatchmultiplatform.core.ApiResult
import com.akcay.justwatchmultiplatform.core.ErrorResponse
import com.akcay.justwatchmultiplatform.core.PageData
import com.akcay.justwatchmultiplatform.data.model.MovieResponse
import com.akcay.justwatchmultiplatform.core.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.setBody

class MoviesService(private val client: HttpClient) {

    suspend fun getPopularMovies(): ApiResult<PageData<MovieResponse>, ErrorResponse> {
        return safeApiCall(
            request = client.get("movie/popular"),
        )
    }
}