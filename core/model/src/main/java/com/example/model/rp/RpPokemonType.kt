package com.example.model.rp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RpPokemonType(
    @SerialName("damage_relations")
    val damageRelations: DamageRelations?,
    @SerialName("name")
    val name: String?
) {
    @Serializable
    data class DamageRelations(
        @SerialName("double_damage_from")
        val doubleDamageFrom: List<Type>?,
        @SerialName("double_damage_to")
        val doubleDamageTo: List<Type>?,
        @SerialName("half_damage_from")
        val halfDamageFrom: List<Type>?,
        @SerialName("half_damage_to")
        val halfDamageTo: List<Type>?,
        @SerialName("no_damage_from")
        val noDamageFrom: List<Type>?,
        @SerialName("no_damage_to")
        val noDamageTo: List<Type>?
    )

    @Serializable
    data class Type(
        @SerialName("name")
        val name: String?,
        @SerialName("url")
        val url: String?
    )
}
