package com.example.data.datasource.local

import com.example.database.room.PokemonDao
import com.example.database.room.PokemonRoomEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonInfoLocalDataSource @Inject constructor(
    private val pokemonDao: PokemonDao
) {
    suspend fun getPokemonList(): Flow<List<PokemonRoomEntity>> = pokemonDao.getPokemonList()
    suspend fun insert(pokemon: PokemonRoomEntity) { pokemonDao.insert(pokemon) }
    suspend fun deleteContent(id: Int) { pokemonDao.deleteById(id) }
    suspend fun clear() { pokemonDao.clear() }
}