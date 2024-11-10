package com.example.data.model.rp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RpPokemonInfo(
    @SerialName("abilities")
    val abilities: List<Ability>?,
    @SerialName("base_experience")
    val baseExperience: Int?,
    @SerialName("height")
    val height: Int?,
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("stats")
    val stats: List<Stat>?,
    @SerialName("types")
    val types: List<Type>?,
    @SerialName("weight")
    val weight: Int?
) {
    @Serializable
    data class Ability(
        @SerialName("ability")
        val ability: AbilityX?,
        @SerialName("is_hidden")
        val isHidden: Boolean?,
        @SerialName("slot")
        val slot: Int?
    ) {
        @Serializable
        data class AbilityX(
            @SerialName("name")
            val name: String?,
            @SerialName("url")
            val url: String?
        )
    }

    @Serializable
    data class Stat(
        @SerialName("base_stat")
        val baseStat: Int?,
        @SerialName("effort")
        val effort: Int?,
        @SerialName("stat")
        val stat: StatX?
    ) {
        @Serializable
        data class StatX(
            @SerialName("name")
            val name: String?,
            @SerialName("url")
            val url: String?
        )
    }

    @Serializable
    data class Type(
        @SerialName("slot")
        val slot: Int?,
        @SerialName("type")
        val type: TypeX?
    ) {
        @Serializable
        data class TypeX(
            @SerialName("name")
            val name: String?,
            @SerialName("type")
            val url: String?
        )
    }
}
