package com.example.data.datasource.local

import com.example.database.dataStore.PokemonInfoDataStore
import com.example.database.room.PokemonDao
import com.example.database.room.PokemonRoomEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonInfoLocalDataSourceImpl @Inject constructor(
    private val pokemonDao: PokemonDao
): PokemonInfoLocalDataSource {
    override suspend fun getPokemonList(): Flow<List<PokemonRoomEntity>> = pokemonDao.getPokemonList()
    override suspend fun insert(pokemon: PokemonRoomEntity) { pokemonDao.insert(pokemon) }
    override suspend fun deleteContent(id: Int) { pokemonDao.deleteById(id) }
    override suspend fun clear() { pokemonDao.clear() }
}