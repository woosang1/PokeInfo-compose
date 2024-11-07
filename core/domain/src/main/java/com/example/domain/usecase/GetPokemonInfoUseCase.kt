package com.example.domain.usecase

import com.example.domain.model.PokemonInfo
import com.example.domain.repository.PokemonInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonInfoUseCase @Inject constructor(
    private val pokemonInfoRepository: PokemonInfoRepository
) {

    suspend fun getInfo(limit: Int?, offset: Int?): Flow<List<PokemonInfo>> =
        pokemonInfoRepository.getPokemonInfo(
            limit = limit,
            offset = offset
        )
}