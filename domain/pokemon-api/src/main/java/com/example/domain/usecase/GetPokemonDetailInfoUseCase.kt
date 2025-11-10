package com.example.domain.usecase

import com.example.model.ui.Pokemon

fun interface GetPokemonDetailInfoUseCase {
    suspend operator fun invoke(id: Int): Pokemon
}
