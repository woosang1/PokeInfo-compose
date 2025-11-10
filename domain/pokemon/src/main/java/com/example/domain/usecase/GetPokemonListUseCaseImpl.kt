package com.example.domain.usecase

import androidx.paging.PagingData
import com.example.data.repository.PokemonRepository
import com.example.model.ui.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonListUseCaseImpl @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : GetPokemonListUseCase {
    override operator fun invoke(page: Int): Flow<PagingData<Pokemon>> =
        pokemonRepository.getPokemonList(page = page)
}