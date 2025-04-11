package com.example.database.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.model.ui.Pokemon
import com.example.model.ui.PokemonType

@Entity(tableName = "pokemon_table")
data class PokemonRoomEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val url: String,
    val weight: Int,
    val height: Int,
    val count: Int,
    val color: String,
    val isLike: Boolean,
    val baseExperience: Int,
    val abilities: List<String>,
    val stats: Pokemon.Stats,
    val types: List<String>,
    val pokemonType: PokemonType?,
    val description: String,
    val genderRate: Pair<Double, Double>,
    val eggGroups: String,
    val eggCycle: Int
)