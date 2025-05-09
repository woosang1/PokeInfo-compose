package com.example.model.ui

import kotlinx.serialization.Serializable

@Serializable
data class EvolutionModel(
    val name: String,
    val spriteImageUrl: String,
    val spritesShinyImageUrl: String
)
