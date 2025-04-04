package com.petros.efthymiou.dailypulse.sources.data

import com.petros.efthymiou.dailypulse.sources.data.SourceRaw
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourcesResponse(
    @SerialName("status")
    val status: String,
    @SerialName("sources")
    val sources: List<SourceRaw>
)
