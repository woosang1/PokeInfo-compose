package com.example.network

import com.example.model.rp.RpPokemonInfo
import com.example.model.rp.RpPokemonList
import com.example.model.rp.RpPokemonType
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
    ): RpPokemonInfo

    /**
     * 타입 약점 / 강점 정보
     */
    @GET("type/")
    suspend fun getPokemonTypeInfo(
        @Query("type") type: String
    ): RpPokemonType
}
