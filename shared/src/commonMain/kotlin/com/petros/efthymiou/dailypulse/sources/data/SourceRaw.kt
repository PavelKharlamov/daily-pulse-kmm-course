package com.petros.efthymiou.dailypulse.sources.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourceRaw(
    @SerialName("name")
    val title: String,
    @SerialName("description")
    val desc: String?,
    @SerialName("language")
    val language: String?,
    @SerialName("country")
    val country: String?,
)
