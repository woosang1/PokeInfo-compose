package com.example.domain.usecase

fun interface ClearPokemonUseCase {
    suspend operator fun invoke(id: Int)
}
