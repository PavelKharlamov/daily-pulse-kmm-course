package com.petros.efthymiou.dailypulse.articles.data

import com.petros.efthymiou.dailypulse.common.NetworkConstants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {
    private val country = "us"
    private val category = "business"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse = httpClient.get(getArticlesPath()).body()
        return response.articles
    }

    private fun getArticlesPath(): String {
        return NetworkConstants.getArticlesUrl() + "?country=$country&category=$category&apiKey=${NetworkConstants.apiKey}"
    }
}