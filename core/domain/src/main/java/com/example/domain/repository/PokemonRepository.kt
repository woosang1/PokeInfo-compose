package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    /** remote **/
    fun getPokemonList(page: Int): Flow<PagingData<Pokemon>>
    suspend fun getPokemonInfo(id: Int, onError : (String) -> Unit): Flow<Pokemon>
    
    /** local **/
    fun insertLocalDB()
    fun clearLocalDB()
    fun deleteLocalDB(id: String)
}