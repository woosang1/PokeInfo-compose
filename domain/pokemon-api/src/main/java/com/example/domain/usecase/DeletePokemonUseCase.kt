package com.example.domain.usecase

fun interface DeletePokemonUseCase {
    suspend operator fun invoke(id: Int)
}
