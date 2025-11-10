package com.example.data.datasource.remote

import com.example.data.api.fake.FakePokemonAPI
import com.example.model.rp.RpPokemonInfo
import com.example.model.rp.RpPokemonList
import com.example.model.rp.RpPokemonSpecies
import com.example.model.rp.RpPokemonType

internal class FakePokemonRemoteDataSource(
    private val pokemonAPI: FakePokemonAPI
) : PokemonRemoteDataSource {

    override suspend fun getPokemonList(page: Int, limit: Int): RpPokemonList
        = pokemonAPI.getPokemonList(limit = 0, offset = page)

    override suspend fun getPokemonInfo(id: Int): RpPokemonInfo
        = pokemonAPI.getPokemonInfo(id)

    override suspend fun getPokemonSpeciesInfo(id: Int): RpPokemonSpecies
        = pokemonAPI.getPokemonSpeciesInfo(id)

    override suspend fun getPokemonTypeInfo(type: String): RpPokemonType
        = pokemonAPI.getPokemonTypeInfo(type)
}