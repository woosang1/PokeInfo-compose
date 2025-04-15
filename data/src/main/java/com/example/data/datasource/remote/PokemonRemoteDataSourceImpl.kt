package com.example.data.datasource.remote

import com.example.model.rp.RpPokemonInfo
import com.example.model.rp.RpPokemonSpecies
import com.example.model.rp.RpPokemonType
import com.example.network.PokemonAPI
import javax.inject.Inject

 class PokemonRemoteDataSourceImpl @Inject constructor(
    private val pokemonApi: PokemonAPI
): PokemonRemoteDataSource {
    override suspend fun getPokemonList(
        page: Int,
        limit: Int
    ) = pokemonApi.getPokemonList(offset = page, limit = limit)
     override suspend fun getPokemonInfo(id: Int) : RpPokemonInfo = pokemonApi.getPokemonInfo(id = id)
     override suspend fun getPokemonSpeciesInfo(id: Int) : RpPokemonSpecies = pokemonApi.getPokemonSpeciesInfo(id = id)
     override suspend fun getPokemonTypeInfo(type: String) : RpPokemonType = pokemonApi.getPokemonTypeInfo(type = type)
}