package com.example.domain.usecase

import androidx.paging.PagingData
import com.example.model.ui.Pokemon
import com.example.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    operator fun invoke(page: Int): Flow<PagingData<com.example.model.ui.Pokemon>> = pokemonRepository.getPokemonList(page = page)
}