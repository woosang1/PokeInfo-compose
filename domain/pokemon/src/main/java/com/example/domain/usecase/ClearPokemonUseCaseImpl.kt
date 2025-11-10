package com.example.domain.usecase

import com.example.data.repository.PokemonRepository
import javax.inject.Inject

class ClearPokemonUseCaseImpl @Inject constructor(
    private val repository: PokemonRepository
) : ClearPokemonUseCase {
    override suspend operator fun invoke(id: Int) {
        repository.deleteLocalDB(id)
    }
}