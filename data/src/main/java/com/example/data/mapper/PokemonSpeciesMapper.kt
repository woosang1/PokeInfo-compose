package com.example.data.mapper

import com.example.model.ui.Pokemon

import com.example.model.rp.RpPokemonSpecies

internal fun RpPokemonSpecies.toEntity(): Pokemon {

    val genderRate = when (this.genderRate) {
        null, -1 -> Pair(0.0, 0.0)
        else -> {
            val female = this.genderRate!! * 12.5
            val male = 100 - female
            Pair(male, female)
        }
    }

    val eggGroups = this.eggGroups
        ?.mapNotNull { it?.name }
        ?.joinToString(", ")
        .orEmpty()

    val eggCycle = this.hatchCounter

    val description = this.flavorTextEntries
        ?.firstOrNull { it?.language?.name == "ko" }
        ?.flavorText
        ?.replace("\n", " ")
        ?.replace("\u000c", " ")
        .orEmpty()

    return Pokemon(
        id = this.id,
        name = this.name,
        color = this.color.name,
        description = description,
        genderRate = genderRate,
        eggGroups = eggGroups,
        eggCycle = eggCycle
    )
}

