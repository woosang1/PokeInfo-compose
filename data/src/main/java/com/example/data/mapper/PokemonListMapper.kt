package com.example.data.mapper

import com.example.model.rp.RpPokemonList
import com.example.model.ui.Pokemon
import com.example.model.ui.PokemonList
import com.example.model.ui.getId
import com.example.model.ui.getImageUrl
import com.example.model.ui.getSpriteImageUrl
import com.example.model.ui.getSpritesShinyImageUrl

internal fun RpPokemonList.toEntity(): PokemonList {
    return PokemonList(
        count = this.count ?: 0,
        next = this.next ?: "",
        previous = this.previous ?: "",
        results = this.results.map { it.toEntity() }
    )
}

internal fun RpPokemonList.Pokemon.toEntity(): Pokemon {
    val id = getId(this.url)
    return Pokemon(
        id = id.toIntOrNull() ?: 0,
        count = this.count,
        name = this.name,
        url = getImageUrl(id = id),
        spriteImageUrl = getSpriteImageUrl(id),
        spritesShinyImageUrl = getSpritesShinyImageUrl(id),
        description = "",
        genderRate = Pair(0.0, 0.0),
        eggGroups = "",
        eggCycle = 0
    )
}