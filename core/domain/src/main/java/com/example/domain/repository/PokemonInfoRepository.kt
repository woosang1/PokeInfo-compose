package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.PokemonList
import kotlinx.coroutines.flow.Flow

interface PokemonInfoRepository {
    /** remote **/
    fun getPokemonList(page: Int) : Flow<PagingData<PokemonList.Pokemon>>

    /** local **/
    fun insertLocalDB()
    fun clearLocalDB()
    fun deleteLocalDB(id: String)
}