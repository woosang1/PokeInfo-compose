package com.example.database.room

import androidx.room.TypeConverter
import com.example.model.ui.Pokemon
import com.example.model.ui.PokemonType
import kotlinx.serialization.json.Json

class RoomConverters {

    private val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun statsToString(stats: Pokemon.Stats): String = json.encodeToString(stats)

    @TypeConverter
    fun stringToStats(data: String): Pokemon.Stats = json.decodeFromString(data)

    @TypeConverter
    fun listToString(list: List<String>): String = json.encodeToString(list)

    @TypeConverter
    fun stringToList(data: String): List<String> = json.decodeFromString(data)

    @TypeConverter
    fun pairToString(pair: Pair<Double, Double>): String = json.encodeToString(pair)

    @TypeConverter
    fun stringToPair(data: String): Pair<Double, Double> = json.decodeFromString(data)

    @TypeConverter
    fun pokemonTypeToString(type: PokemonType?): String = json.encodeToString(type)

    @TypeConverter
    fun stringToPokemonType(data: String): PokemonType = json.decodeFromString(data)
}
