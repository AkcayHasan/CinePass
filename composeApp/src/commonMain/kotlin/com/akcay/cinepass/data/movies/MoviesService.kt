package com.akcay.cinepass.data.movies

import com.akcay.cinepass.core.ApiResult
import com.akcay.cinepass.core.ErrorResponse
import com.akcay.cinepass.core.PageData
import com.akcay.cinepass.data.model.MovieResponse
import com.akcay.cinepass.core.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class MoviesService(private val client: HttpClient) {

    suspend fun getPopularMovies(): ApiResult<PageData<MovieResponse>, ErrorResponse> {
        return safeApiCall(
            request = client.get("movie/popular"),
        )
    }
}