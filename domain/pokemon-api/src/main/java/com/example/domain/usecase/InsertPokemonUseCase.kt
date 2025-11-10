package com.example.domain.usecase

import com.example.model.ui.Pokemon

fun interface InsertPokemonUseCase {
    suspend operator fun invoke(pokemon: Pokemon)
}
