package com.example.data.mapper

import com.example.model.ui.Pokemon
import com.example.model.ui.PokemonList
import com.example.model.ui.getId
import com.example.model.ui.getImageUrl
import com.example.model.rp.RpPokemonList

internal fun RpPokemonList.toDomain(): PokemonList {
    return PokemonList(
        count = this.count ?: 0,
        next = this.next ?: "",
        previous = this.previous ?: "",
        results = this.results.map { it.toDomain() }
    )
}

internal fun RpPokemonList.Pokemon.toDomain(): Pokemon {
    return Pokemon(
        id = getId(this.url).toIntOrNull() ?: 0,
        count = this.count,
        name = this.name,
        url = getImageUrl(this.url)
    )
}