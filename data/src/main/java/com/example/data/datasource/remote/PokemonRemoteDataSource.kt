package com.example.data.datasource.remote

import com.example.model.rp.RpPokemonInfo
import com.example.model.rp.RpPokemonList
import com.example.model.rp.RpPokemonSpecies
import com.example.model.rp.RpPokemonType

interface PokemonRemoteDataSource {
    suspend fun getPokemonList(page: Int, limit: Int): RpPokemonList
    suspend fun getPokemonInfo(id: Int): RpPokemonInfo
    suspend fun getPokemonSpeciesInfo(id: Int): RpPokemonSpecies
    suspend fun getPokemonTypeInfo(type: String): RpPokemonType
}
