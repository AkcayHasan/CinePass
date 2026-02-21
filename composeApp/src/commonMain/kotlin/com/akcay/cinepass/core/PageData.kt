package com.akcay.cinepass.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class PageData<T>(
    @SerialName("results") val data: List<T>,
    @SerialName("page") val page: Int,
    @SerialName("total_pages") val totalPages: Int
)
