package com.example.data.mapper

import com.example.model.ui.Pokemon
import com.example.model.rp.RpPokemonInfo

fun RpPokemonInfo.toDomain(): Pokemon {
    return Pokemon(
        id = this.id ?: 0,
        name = this.name ?: "",
        url = "",
        weight = this.weight ?: 0,
        height = this.height ?: 0,
        baseExperience = this.baseExperience ?: 0,
        abilities = this.abilities?.map { ability ->
            ability.ability?.name ?: ""
        } ?: emptyList(),

        stats = Pokemon.Stats(
            hp = getStatValue("hp"),
            attack = getStatValue("attack"),
            defense = getStatValue("defense"),
            specialAttack = getStatValue("special-attack"),
            specialDefense = getStatValue("special-defense"),
            speed = getStatValue("speed")
        ),

        types = this.types?.map { type ->
            type.type?.name ?: ""
        } ?: emptyList(),
        description = "",
        genderRate = Pair(0.0, 0.0),
        eggGroups = "",
        eggCycle = 0
    )
}

private fun RpPokemonInfo.getStatValue(statName: String): Int {
    return this.stats
        ?.firstOrNull { it.stat?.name == statName }
        ?.baseStat ?: 0
}