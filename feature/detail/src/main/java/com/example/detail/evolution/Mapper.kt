package com.example.detail.evolution

import com.example.model.ui.EvolutionModel
import com.example.model.ui.Pokemon

fun Pokemon.toEvolutionModel(): EvolutionModel {
    return EvolutionModel(
        name = this.name,
        spriteImageUrl = this.spriteImageUrl,
        spritesShinyImageUrl = this.spritesShinyImageUrl
    )
}

