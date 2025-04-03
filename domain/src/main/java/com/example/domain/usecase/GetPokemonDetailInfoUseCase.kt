package com.example.domain.usecase

import com.example.model.ui.Pokemon
import com.example.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonDetailInfoUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(id: Int): com.example.model.ui.Pokemon =
        pokemonRepository.getPokemonInfo(id = id)
}