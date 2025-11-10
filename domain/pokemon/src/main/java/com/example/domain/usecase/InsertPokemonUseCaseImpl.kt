package com.example.domain.usecase

import com.example.data.repository.PokemonRepository
import com.example.model.ui.Pokemon
import javax.inject.Inject

class InsertPokemonUseCaseImpl @Inject constructor(
    private val repository: PokemonRepository
) : InsertPokemonUseCase {
    override suspend operator fun invoke(pokemon: Pokemon) {
        repository.insertLocalDB(pokemon)
    }
}