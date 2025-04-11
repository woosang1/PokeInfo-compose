package com.example.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [PokemonRoomEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(RoomConverters::class)
abstract class PokemonRoomDataBase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}
