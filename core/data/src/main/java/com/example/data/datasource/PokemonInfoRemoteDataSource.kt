package com.example.data.datasource

import com.example.data.network.NetworkManager
import com.example.data.network.safeFlow
import javax.inject.Inject

class PokemonInfoRemoteDataSource @Inject constructor(
    private val networkManager: NetworkManager
) {
    suspend fun getPokemonInfo() = safeFlow { networkManager.getPokemonInfo() }
}