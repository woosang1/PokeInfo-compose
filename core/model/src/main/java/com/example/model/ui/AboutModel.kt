package com.example.model.ui

import kotlinx.serialization.Serializable

@Serializable
data class AboutModel(
    val description: String = "",
    val height: Int = 0,
    val weight: Int = 0,
    val genderRate: Pair<Double, Double> = Pair(0.0,0.0),
    val eddGroups: String = "",
    val eggCycle: Int = 0
)