package com.example.data.datasource.local

import com.example.database.room.PokemonRoomEntity
import kotlinx.coroutines.flow.Flow

interface PokemonInfoLocalDataSource {
    suspend fun getPokemonList(): Flow<List<PokemonRoomEntity>>
    suspend fun insert(pokemon: PokemonRoomEntity)
    suspend fun deleteContent(id: Int)
    suspend fun clear()
}