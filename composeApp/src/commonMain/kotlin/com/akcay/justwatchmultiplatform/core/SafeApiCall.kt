package com.akcay.justwatchmultiplatform.core

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

suspend inline fun <reified T> safeApiCall(
    request: HttpResponse,
): ApiResult<T, ErrorResponse> {
    return try {
        when (request.status) {
            HttpStatusCode.OK -> {
                val data: T = request.body()
                ApiResult.Success(data)
            }
            else -> {
                val errorResponse = try {
                    request.body<ErrorResponse>()
                } catch (e: Exception) {
                    ErrorResponse(
                        statusCode = request.status.value,
                        statusMessage = request.status.description
                    )
                }
                ApiResult.Failure(errorResponse)
            }
        }
    } catch (e: Exception) {
        ApiResult.Failure(
            ErrorResponse(
                statusMessage = e.message ?: "Unknown error occurred"
            )
        )
    }
}