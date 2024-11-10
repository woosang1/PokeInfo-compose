package com.example.data.datasource.remote

import com.example.data.network.NetworkAPI
import com.example.data.network.safeFlow
import javax.inject.Inject

class PokemonListRemoteDataSource @Inject constructor(
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
}