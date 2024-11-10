package com.example.domain.model

data class PokemonList(
    val count: Int = 0,
    val next: String = "",
    val previous: String = "",
    val results: List<Pokemon> = emptyList(),
)

