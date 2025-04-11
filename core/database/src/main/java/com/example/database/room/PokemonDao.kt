package com.example.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon_table")
    fun getPokemonList(): Flow<List<PokemonRoomEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: PokemonRoomEntity)

    @Query("DELETE FROM pokemon_table WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("DELETE FROM pokemon_table")
    suspend fun clear()
}
