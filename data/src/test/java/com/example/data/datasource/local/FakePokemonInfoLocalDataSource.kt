package com.example.data.datasource.local

import com.example.database.room.PokemonRoomEntity
import kotlinx.coroutines.flow.Flow

internal class FakePokemonInfoLocalDataSource : PokemonInfoLocalDataSource {
    override suspend fun getPokemonList(): Flow<List<PokemonRoomEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun insert(pokemon: PokemonRoomEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteContent(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }
}
