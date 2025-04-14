package com.example.domain.usecase

import com.example.domain.repository.PokemonRepository
import com.example.model.ui.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLikePokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(): Flow<List<Pokemon>> = pokemonRepository.getLikePokemonList()
}