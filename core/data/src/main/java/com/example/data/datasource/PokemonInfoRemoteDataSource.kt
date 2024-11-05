package com.example.data.datasource

import com.example.data.model.rp.RpPokemonInfo
import com.example.data.network.NetworkManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonInfoRemoteDataSource @Inject constructor(
    private val networkManager: NetworkManager
) {
    fun getInfo() : Flow<RpPokemonInfo> = networkManager.getPokemonInfo()
}