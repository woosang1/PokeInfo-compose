package com.example.data.network

import com.example.data.model.rp.RpPokemonInfo
import com.example.domain.model.PokemonInfo
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkAPI {

    /**
     * 포켓몬 조회
     */
//    @GET("pokemon.json")
//    suspend fun getPokemonInfo(): RpPokemonInfo

    @GET("pokemon")
    suspend fun getPokemonInfo(): RpPokemonInfo

    /**
     * 포켓몬 상세 정보
     */
    @GET("pokemon/")
    fun getPokemonDetailInfo(
        @Query("id") id: Int?,
        @Query("name") name: String?,
    ): Flow<PokemonInfo>
}
