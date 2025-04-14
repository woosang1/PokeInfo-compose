package com.example.data.datasource.remote

import com.example.model.rp.RpPokemonInfo
import com.example.model.rp.RpPokemonSpecies
import com.example.model.rp.RpPokemonType
import com.example.network.PokemonAPI
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(
    private val pokemonApi: PokemonAPI
) {
    suspend fun getPokemonList(
        page: Int,
        limit: Int
    ) = pokemonApi.getPokemonList(offset = page, limit = limit)
    suspend fun getPokemonInfo(id: Int) : RpPokemonInfo = pokemonApi.getPokemonInfo(id = id)
    suspend fun getPokemonSpeciesInfo(id: Int) : RpPokemonSpecies = pokemonApi.getPokemonSpeciesInfo(id = id)
    suspend fun getPokemonTypeInfo(type: String) : RpPokemonType = pokemonApi.getPokemonTypeInfo(type = type)

}