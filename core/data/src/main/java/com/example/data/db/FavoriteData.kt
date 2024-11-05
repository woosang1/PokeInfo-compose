package com.example.data.db

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.domain.model.PokemonInfo


@Entity(tableName = "favorite", indices = [Index(value = ["name"], unique = true)])
data class FavoriteData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val image: String,
    val type: String,
    val abilities: String,
    val attack: Int,
    val baseExp: String,
    val category: String,
    val cycles: String,
    val defense: Int,
    val eggGroups: String,
    val evolutions: String,
    val evolvedfrom: String,
    val femalePercentage: String,
    val genderless: Int,
    val height: String,
    val hp: Int,
    val malePercentage: String,
    val reason: String,
    val specialAttack: Int,
    val specialDefense: Int,
    val speed: Int,
    val total: Int,
    val typeofpokemon: String,
    val weaknesses: String,
    val weight: String,
    val xdescription: String,
    val ydescription: String
)

 /** List -> String으로 변환해야함. **/
// List<String>을 String으로 변환
//@TypeConverter
//fun fromListToString(value: List<String>?): String? {
//    return Gson().toJson(value)
//}
//
//// String을 List<String>으로 변환
//@TypeConverter
//fun fromStringToList(value: String?): List<String>? {
//    val listType = object : TypeToken<List<String>>() {}.type
//    return Gson().fromJson(value, listType)
//}