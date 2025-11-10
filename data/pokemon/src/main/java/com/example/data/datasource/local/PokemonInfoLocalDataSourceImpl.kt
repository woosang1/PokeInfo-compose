package com.example.data.datasource.local

import com.example.database.room.PokemonDao
import com.example.database.room.PokemonRoomEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonInfoLocalDataSourceImpl @Inject constructor(
    private val pokemonDao: PokemonDao
): PokemonInfoLocalDataSource {
    override fun getPokemonList(): Flow<List<PokemonRoomEntity>> = pokemonDao.getPokemonList()
    override fun insert(pokemon: PokemonRoomEntity) { pokemonDao.insert(pokemon) }
    override fun deleteContent(id: Int) { pokemonDao.deleteById(id) }
    override fun clear() { pokemonDao.clear() }
}