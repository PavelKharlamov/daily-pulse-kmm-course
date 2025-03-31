package com.petros.efthymiou.dailypulse.sources.data

import com.petros.efthymiou.dailypulse.sources.data.SourceRaw
import petros.efthymiou.dailypulse.db.DailyPulseDatabase

class SourcesDataSource(private val database: DailyPulseDatabase) {

    fun getAllSources(): List<SourceRaw> =
        database.dailyPulseDatabaseQueries.selectAllSources(::mapToSourceRaw).executeAsList()

    fun insertSources(sources: List<SourceRaw>) {
        database.dailyPulseDatabaseQueries.transaction {
            sources.forEach { sourceRaw ->
                insertSource(sourceRaw)
            }
        }
    }

    fun clearSources() =
        database.dailyPulseDatabaseQueries.removeAllSources()

    private fun insertSource(sourceRaw: SourceRaw) {
        database.dailyPulseDatabaseQueries.insertSource(
            sourceRaw.title,
            sourceRaw.desc,
            sourceRaw.language,
            sourceRaw.country
        )
    }

    private fun mapToSourceRaw(
        title: String,
        desc: String?,
        language: String?,
        country: String?
    ): SourceRaw =
        SourceRaw(
            title,
            desc,
            language,
            country
        )
}