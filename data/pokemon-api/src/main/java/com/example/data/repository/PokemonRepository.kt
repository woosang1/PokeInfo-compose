package com.example.data.repository

import androidx.paging.PagingData
import com.example.model.ui.Pokemon
import com.example.model.ui.PokemonType
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    /** remote **/
    fun getPokemonList(page: Int): Flow<PagingData<Pokemon>>
    suspend fun getPokemonInfo(id: Int): Pokemon
    suspend fun getPokemonSpeciesInfo(id: Int): Pokemon
    suspend fun getPokemonTypeInfo(type: String): PokemonType

    /** local **/
    fun getLikePokemonList(): Flow<List<Pokemon>>
    suspend fun insertLocalDB(pokemon: Pokemon)
    suspend fun deleteLocalDB(id: Int)
    suspend fun clearLocalDB()
}
