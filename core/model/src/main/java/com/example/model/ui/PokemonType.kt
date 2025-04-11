package com.example.model.ui

import kotlinx.serialization.Serializable

@Serializable
data class PokemonType(
    val damageRelations: DamageRelations?,
    val name: String?
) {
    @Serializable
    data class DamageRelations(
        val doubleDamageFrom: List<Type>?,
        val doubleDamageTo: List<Type>?,
        val halfDamageFrom: List<Type>?,
        val halfDamageTo: List<Type>?,
        val noDamageFrom: List<Type>?,
        val noDamageTo: List<Type>?
    )

    @Serializable
    data class Type(
        val name: String?,
        val url: String?
    )
}