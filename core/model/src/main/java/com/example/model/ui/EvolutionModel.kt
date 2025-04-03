package com.example.model.ui

import kotlinx.serialization.Serializable

@Serializable
data class EvolutionModel(
    val hp: Int = 0,
    val attack: Int = 0,
    val defense: Int = 0,
    val specialAttack: Int = 0,
    val specialDefense: Int = 0,
    val speed: Int = 0,
    val total: Int = 0
)
