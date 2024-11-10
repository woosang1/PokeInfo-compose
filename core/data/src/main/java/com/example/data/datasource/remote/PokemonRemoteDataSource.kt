package com.example.data.datasource.remote

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

    fun getPokemonInfo(
        id: Int
    ) = safeFlow {
        networkApi.getPokemonDetailInfo(id = id)
    }
}