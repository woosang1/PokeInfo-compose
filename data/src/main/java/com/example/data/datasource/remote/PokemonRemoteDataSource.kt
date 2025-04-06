package com.example.data.datasource.remote

import com.example.model.rp.RpPokemonInfo
import com.example.model.rp.RpPokemonSpecies
import com.example.model.rp.RpPokemonType
import com.example.network.NetworkAPI
import com.example.network.safeFlow
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(
    private val networkApi: NetworkAPI
) {
    fun getPokemonList(
        page: Int,
        limit: Int
    ) = safeFlow {
        networkApi.getPokemonList(
            offset = page,
            limit = limit
        )
    }

    suspend fun getPokemonInfo(id: Int) : RpPokemonInfo = networkApi.getPokemonInfo(id = id)
    suspend fun getPokemonSpeciesInfo(id: Int) : RpPokemonSpecies = networkApi.getPokemonSpeciesInfo(id = id)
    suspend fun getPokemonTypeInfo(type: String) : RpPokemonType = networkApi.getPokemonTypeInfo(type = type)

}