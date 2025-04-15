package com.example.data.api.fake

import com.example.model.rp.RpPokemonInfo
import com.example.model.rp.RpPokemonList
import com.example.model.rp.RpPokemonSpecies
import com.example.model.rp.RpPokemonType
import com.example.network.PokemonAPI

class FakePokemonAPI : PokemonAPI {

    override suspend fun getPokemonList(limit: Int, offset: Int): RpPokemonList {
        return RpPokemonList(
            count = 2,
            next = null,
            previous = null,
            results = listOf(
                RpPokemonList.Pokemon(
                    name = "bulbasaur",
                    url = "https://pokeapi.co/api/v2/pokemon/1/"
                ),
                RpPokemonList.Pokemon(
                    name = "pikachu",
                    url = "https://pokeapi.co/api/v2/pokemon/25/"
                )
            )
        )
    }

    override suspend fun getPokemonInfo(id: Int): RpPokemonInfo {
        TODO("RpPokemonInfo에 맞게 구현")
    }

    override suspend fun getPokemonSpeciesInfo(id: Int): RpPokemonSpecies {
        TODO("RpPokemonSpecies에 맞게 구현")
    }

    override suspend fun getPokemonTypeInfo(type: String): RpPokemonType {
        TODO("RpPokemonType에 맞게 구현")
    }
}