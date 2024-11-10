package com.example.data.mapper

import com.example.data.model.rp.RpPokemonInfo
import com.example.domain.model.Pokemon

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
        stats = this.stats?.mapNotNull { stat ->
            stat.stat?.name?.let { name ->
                name to (stat.baseStat ?: 0)
            }
        }?.toMap() ?: emptyMap(),
        types = this.types?.map { type ->
            type.type?.name ?: ""
        } ?: emptyList()
    )
}