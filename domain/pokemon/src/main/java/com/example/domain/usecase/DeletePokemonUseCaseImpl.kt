package com.example.domain.usecase

import com.example.data.repository.PokemonRepository
import javax.inject.Inject

class DeletePokemonUseCaseImpl @Inject constructor(
    private val repository: PokemonRepository
) : DeletePokemonUseCase {
    override suspend operator fun invoke(id: Int) {
        repository.deleteLocalDB(id)
    }
}