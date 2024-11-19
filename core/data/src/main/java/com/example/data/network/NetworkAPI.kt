package com.example.data.network

import com.example.data.model.rp.RpPokemonInfo
import com.example.data.model.rp.RpPokemonList
import com.example.data.model.rp.RpPokemonType
import com.example.domain.model.PokemonList
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkAPI {

    /**
     * 포켓몬 조회
     */
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int = 0,
    ): RpPokemonList

    /**
     * 포켓몬 상세 정보
     */
    @GET("pokemon/")
    suspend fun getPokemonDetailInfo(
        @Query("id") id: Int
    ): Flow<RpPokemonInfo>

    /**
     * 타입 약점 / 강점 정보
     */
    @GET("type/")
    suspend fun getPokemonTypeInfo(
        @Query("type") type: String
    ): Flow<RpPokemonType>
}
