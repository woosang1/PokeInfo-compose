package com.example.data.model.rp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RpPokemonInfo(
    val pokemonItems: List<RpPokemonItem>
) {
    @Serializable
    data class RpPokemonItem(
        @SerialName("abilities")
        val abilities: List<String?>?,

        @SerialName("attack")
        val attack: Int?,

        @SerialName("base_exp")
        val baseExp: String?,

        @SerialName("category")
        val category: String?,

        @SerialName("cycles")
        val cycles: String?,

        @SerialName("defense")
        val defense: Int?,

        @SerialName("egg_groups")
        val eggGroups: String?,

        @SerialName("evolutions")
        val evolutions: List<String?>?,

        @SerialName("evolvedfrom")
        val evolvedFrom: String?,

        @SerialName("female_percentage")
        val femalePercentage: String?,

        @SerialName("genderless")
        val genderless: Int?,

        @SerialName("height")
        val height: String?,

        @SerialName("hp")
        val hp: Int?,

        @SerialName("id")
        val id: String?,

        @SerialName("imageurl")
        val imageUrl: String?,

        @SerialName("male_percentage")
        val malePercentage: String?,

        @SerialName("name")
        val name: String?,

        @SerialName("reason")
        val reason: String?,

        @SerialName("special_attack")
        val specialAttack: Int?,

        @SerialName("special_defense")
        val specialDefense: Int?,

        @SerialName("speed")
        val speed: Int?,

        @SerialName("total")
        val total: Int?,

        @SerialName("typeofpokemon")
        val typeOfPokemon: List<String>?,

        @SerialName("weaknesses")
        val weaknesses: List<String?>?,

        @SerialName("weight")
        val weight: String?,

        @SerialName("xdescription")
        val xDescription: String?,

        @SerialName("ydescription")
        val yDescription: String?
    )
}

