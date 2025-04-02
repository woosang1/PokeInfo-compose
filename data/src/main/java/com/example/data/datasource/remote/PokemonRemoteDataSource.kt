package com.example.data.datasource.remote

import com.example.network.NetworkAPI
import com.example.data.network.safeFlow
import com.example.model.rp.RpPokemonInfo
import com.example.model.rp.RpPokemonType
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

    suspend fun getPokemonInfo(id: Int) : com.example.model.rp.RpPokemonInfo = networkApi.getPokemonDetailInfo(id = id)

    suspend fun getPokemonTypeInfo(type: String) : com.example.model.rp.RpPokemonType = networkApi.getPokemonTypeInfo(type = type)

}