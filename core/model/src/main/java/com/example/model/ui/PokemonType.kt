package com.example.model.ui

data class PokemonType(
    val damageRelations: DamageRelations?,
    val name: String?
) {
    data class DamageRelations(
        val doubleDamageFrom: List<Type>?,
        val doubleDamageTo: List<Type>?,
        val halfDamageFrom: List<Type>?,
        val halfDamageTo: List<Type>?,
        val noDamageFrom: List<Type>?,
        val noDamageTo: List<Type>?
    )

    data class Type(
        val name: String?,
        val url: String?
    )
}