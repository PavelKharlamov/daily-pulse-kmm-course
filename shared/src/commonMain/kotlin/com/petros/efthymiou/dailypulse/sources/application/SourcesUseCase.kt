package com.petros.efthymiou.dailypulse.sources.application

import com.petros.efthymiou.dailypulse.sources.application.Source
import com.petros.efthymiou.dailypulse.sources.data.SourceRaw
import com.petros.efthymiou.dailypulse.sources.data.SourcesRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class SourcesUseCase(private val repo: SourcesRepository) {

    suspend fun getSources(forceFetch: Boolean): List<Source> {
        val sourcesRaw = repo.getSources(forceFetch)
        return mapSources(sourcesRaw)
    }

    private fun mapSources(sourcesRaw: List<SourceRaw>): List<Source> = sourcesRaw.map { raw ->
        Source(
            raw.title,
            raw.desc ?: "No description",
            raw.language ?: "Unknown language",
            raw.country ?: "Unknown country",
        )
    }
}