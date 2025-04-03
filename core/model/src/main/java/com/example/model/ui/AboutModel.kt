package com.example.model.ui

import kotlinx.serialization.Serializable

@Serializable
data class AboutModel(
    val description: String = ""
)