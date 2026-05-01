package org.example.project.data

class NewsRepository(private val api: NewsApi) {
    suspend fun getNews(): List<Article> {
        return api.fetchTopHeadlines().articles
    }
}
