package com.example.data.datasource.remote

import com.example.data.model.rp.RpPokemonInfo
import com.example.data.model.rp.RpPokemonType
import com.example.data.network.NetworkAPI
import com.example.data.network.safeFlow
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

    suspend fun getPokemonInfo(id: Int) : RpPokemonInfo = networkApi.getPokemonDetailInfo(id = id)

    suspend fun getPokemonTypeInfo(type: String) : RpPokemonType = networkApi.getPokemonTypeInfo(type = type)

}