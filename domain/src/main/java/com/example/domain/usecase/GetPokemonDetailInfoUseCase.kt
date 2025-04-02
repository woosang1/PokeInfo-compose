package com.example.domain.usecase

import com.example.domain.model.Pokemon
import com.example.domain.repository.PokemonRepository
import com.example.log.DebugLog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonDetailInfoUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(id: Int): Pokemon =
        pokemonRepository.getPokemonInfo(id = id)
}