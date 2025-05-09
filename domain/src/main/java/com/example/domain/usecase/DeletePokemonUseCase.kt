package com.example.domain.usecase

import com.example.domain.repository.PokemonRepository
import javax.inject.Inject

class DeletePokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(id: Int) {
        repository.deleteLocalDB(id)
    }
}