package com.example.domain.usecase

import com.example.domain.repository.PokemonRepository
import com.example.model.ui.Pokemon
import javax.inject.Inject

class InsertPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(pokemon: Pokemon) {
        repository.insertLocalDB(pokemon)
    }
}