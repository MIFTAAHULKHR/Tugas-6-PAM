package org.example.project.data

import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

@Serializable
data class Article(
    val title: String?,
    val description: String?,
    val urlToImage: String?,
    val url: String?,
    val content: String?
)
