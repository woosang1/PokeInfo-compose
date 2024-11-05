package com.example.data.network

import com.example.data.model.rp.RpPokemonInfo
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkAPI {

    /**
     * 포켓몬 조회
     */
    @GET("pokemon.json")
    fun getPokemonInfo(): Flow<RpPokemonInfo>

    /**
     * 포켓몬 상세 정보
     */
    @GET("pokemon/")
    fun getPokemonDetailInfo(
        @Query("id") id: Int?,
        @Query("name") name: String?,
    ): Flow<RpPokemonInfo>
}
