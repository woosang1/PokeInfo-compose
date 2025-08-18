package com.example.data.datasource.local

import com.example.database.room.PokemonRoomEntity
import kotlinx.coroutines.flow.Flow

interface PokemonInfoLocalDataSource {
    fun getPokemonList(): Flow<List<PokemonRoomEntity>>
    fun insert(pokemon: PokemonRoomEntity)
    fun deleteContent(id: Int)
    fun clear()
}