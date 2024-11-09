package com.example.domain.repository

import com.example.domain.model.PokemonList
import kotlinx.coroutines.flow.Flow

interface PokemonInfoRepository {
    /** remote **/
    suspend fun getPokemonInfo(limit: Int, offset: Int, onError: (String) -> Unit) : Flow<PokemonList>

    /** local **/
    fun insertLocalDB()
    fun clearLocalDB()
    fun deleteLocalDB(id: String)
}