package com.example.database.room

import androidx.room.TypeConverter
import com.example.model.ui.Pokemon
import com.example.model.ui.PokemonType
import kotlinx.serialization.json.Json

class RoomConverters {

    private val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun statsToString(stats: Pokemon.Stats?): String {
        return json.encodeToString(stats)
    }

    @TypeConverter
    fun stringToStats(data: String?): Pokemon.Stats {
        return if (data.isNullOrEmpty() || data == "null") {
            Pokemon.Stats()
        } else {
            json.decodeFromString(data)
        }
    }

    @TypeConverter
    fun listToString(list: List<String>?): String {
        return json.encodeToString(list ?: emptyList())
    }

    @TypeConverter
    fun stringToList(data: String?): List<String> {
        return if (data.isNullOrEmpty() || data == "null") {
            emptyList()
        } else {
            json.decodeFromString(data)
        }
    }

    @TypeConverter
    fun pairToString(pair: Pair<Double, Double>?): String {
        return json.encodeToString(pair ?: Pair(0.0, 0.0))
    }

    @TypeConverter
    fun stringToPair(data: String?): Pair<Double, Double> {
        return if (data.isNullOrEmpty() || data == "null") {
            Pair(0.0, 0.0)
        } else {
            json.decodeFromString(data)
        }
    }

    @TypeConverter
    fun pokemonTypeToString(type: PokemonType?): String {
        return json.encodeToString(type)
    }

    @TypeConverter
    fun stringToPokemonType(data: String?): PokemonType? {
        return if (data.isNullOrEmpty() || data == "null") {
            null
        } else {
            json.decodeFromString(data)
        }
    }
}