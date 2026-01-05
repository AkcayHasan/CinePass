package com.akcay.justwatchmultiplatform.core

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val statusCode: Int? = null,
    val statusMessage: String,
    val success: Boolean? = null
) {
    val displayMessage: String
        get() = statusMessage.ifEmpty { "An error occurred" }
}