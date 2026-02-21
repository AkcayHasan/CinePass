package com.akcay.cinepass.di

import com.akcay.cinepass.core.ApiConstants
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = false
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = ApiConstants.BASE_HOST
                    path(ApiConstants.BASE_PATH)
                }
                headers {
                    append(HttpHeaders.Authorization, "Bearer ${ApiConstants.API_TOKEN}")
                    append(HttpHeaders.Accept, ApiConstants.ACCEPT_HEADER)
                }
            }
        }
    }
}