package com.example.data.network

import com.example.data.model.rp.RpPokemonInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Provider

class NetworkManager @Inject constructor(
    private val retrofitClient: Provider<RetrofitClient>
) {
    fun getPokemonInfo(): Flow<RpPokemonInfo> = retrofitClient.get().getRetrofitByGistGithubUrl(NetworkAPI::class.java).getPokemonInfo()

}

