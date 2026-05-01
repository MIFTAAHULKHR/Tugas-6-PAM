package org.example.project.data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlin.random.Random

class NewsApi {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
            })
        }
    }

    suspend fun fetchTopHeadlines(): NewsResponse {
        return client.get("https://newsapi.org/v2/top-headlines") {
            parameter("country", "us")
            parameter("apiKey", "c55a2ef964ec4367883e121fd4af23dc")
            // Gunakan angka acak untuk menghindari caching tanpa perlu library datetime
            parameter("refresh", Random.nextInt())
            header(HttpHeaders.CacheControl, "no-cache")
        }.body()
    }
}
