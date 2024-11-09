package com.example.data.datasource

import com.example.data.network.NetworkAPI
import com.example.data.network.safeFlow
import javax.inject.Inject

class PokemonListRemoteDataSource @Inject constructor(
    private val networkApi : NetworkAPI
) {
    fun getPokemonList() = safeFlow { networkApi.getPokemonList() }
}