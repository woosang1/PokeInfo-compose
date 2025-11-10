package com.example.domain.usecase

import com.example.data.repository.PokemonRepository
import com.example.model.ui.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLikePokemonListUseCaseImpl @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : GetLikePokemonListUseCase {
    override operator fun invoke(): Flow<List<Pokemon>> = pokemonRepository.getLikePokemonList()
}