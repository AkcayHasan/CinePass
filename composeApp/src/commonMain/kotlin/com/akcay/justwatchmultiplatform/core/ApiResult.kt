package com.akcay.justwatchmultiplatform.core

/**
 * Result type for API calls
 * Success contains the data, Failure contains the error response
 */
sealed class ApiResult<out T, out E> {
    data class Success<T>(val data: T) : ApiResult<T, Nothing>()
    data class Failure<E>(val error: E) : ApiResult<Nothing, E>()
    
    fun isSuccess(): Boolean = this is Success
    fun isFailure(): Boolean = this is Failure
    
    inline fun <R> fold(
        onSuccess: (T) -> R,
        onFailure: (E) -> R
    ): R = when (this) {
        is Success -> onSuccess(data)
        is Failure -> onFailure(error)
    }
    
    inline fun <R> map(transform: (T) -> R): ApiResult<R, E> = when (this) {
        is Success -> Success(transform(data))
        is Failure -> this
    }
    
    inline fun <R> mapError(transform: (E) -> R): ApiResult<T, R> = when (this) {
        is Success -> this
        is Failure -> Failure(transform(error))
    }
}

inline fun <T, E> ApiResult<T, E>.onSuccess(
    action: (T) -> Unit
): ApiResult<T, E> {
    if (this is ApiResult.Success) {
        action(data)
    }
    return this
}

inline fun <T, E> ApiResult<T, E>.onFailure(
    action: (E) -> Unit
): ApiResult<T, E> {
    if (this is ApiResult.Failure) {
        action(error)
    }
    return this
}

