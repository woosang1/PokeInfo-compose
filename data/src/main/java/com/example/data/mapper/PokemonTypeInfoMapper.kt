package com.example.data.mapper

import com.example.model.ui.PokemonType
import com.example.model.rp.RpPokemonType

fun RpPokemonType.toDomain(): PokemonType {
    return PokemonType(
        damageRelations = this.damageRelations?.let {
            PokemonType.DamageRelations(
                doubleDamageFrom = it.doubleDamageFrom?.map { type -> PokemonType.Type(type.name, type.url) },
                doubleDamageTo = it.doubleDamageTo?.map { type -> PokemonType.Type(type.name, type.url) },
                halfDamageFrom = it.halfDamageFrom?.map { type -> PokemonType.Type(type.name, type.url) },
                halfDamageTo = it.halfDamageTo?.map { type -> PokemonType.Type(type.name, type.url) },
                noDamageFrom = it.noDamageFrom?.map { type -> PokemonType.Type(type.name, type.url) },
                noDamageTo = it.noDamageTo?.map { type -> PokemonType.Type(type.name, type.url) }
            )
        },
        name = this.name
    )
}
