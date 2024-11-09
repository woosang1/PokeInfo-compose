package com.example.data.mapper

import com.example.data.model.rp.RpPokemonInfo
import com.example.domain.model.PokemonInfo
import com.example.domain.model.getId
import com.example.domain.model.getImageUrl

internal fun RpPokemonInfo.toDomain(): PokemonInfo {
    return PokemonInfo(
        count = this.count ?: 0,
        next = this.next ?: "",
        previous = this.previous ?: "",
        results = this.results.map { it.toDomain() }
    )
}

internal fun RpPokemonInfo.Pokemon.toDomain(): PokemonInfo.Pokemon {
    return PokemonInfo.Pokemon(
        id = getId(this.url).toIntOrNull() ?: 0,
        count = this.count,
        name = this.name,
        url = getImageUrl(this.url)
    )
}