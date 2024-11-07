package com.example.domain.repository

import com.example.domain.model.PokemonInfo
import kotlinx.coroutines.flow.Flow

interface PokemonInfoRepository {
    /** remote **/
    suspend fun getPokemonInfo(limit: Int?, offset: Int?) : Flow<List<PokemonInfo>>

    /** local **/
    fun insertLocalDB()
    fun clearLocalDB()
    fun deleteLocalDB(id: String)
}