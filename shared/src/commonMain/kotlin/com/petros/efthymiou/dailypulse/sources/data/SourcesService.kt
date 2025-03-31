package com.petros.efthymiou.dailypulse.sources.data

import com.petros.efthymiou.dailypulse.common.NetworkConstants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(private val httpClient: HttpClient) {
    suspend fun fetchSources(): List<SourceRaw> {
        val response: SourcesResponse = httpClient.get(getSourcesPath()).body()
        return response.sources
    }

    private fun getSourcesPath(): String {
        return NetworkConstants.getSourcesUrl() + "?apiKey=${NetworkConstants.apiKey}"
    }
}