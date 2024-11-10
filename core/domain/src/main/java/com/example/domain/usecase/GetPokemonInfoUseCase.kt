package com.example.domain.usecase

import androidx.paging.PagingData
import com.example.domain.model.PokemonList
import com.example.domain.repository.PokemonInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonInfoUseCase @Inject constructor(
    private val pokemonInfoRepository: PokemonInfoRepository
) {

    suspend fun getInfo(page: Int): Flow<PagingData<PokemonList.Pokemon>> = pokemonInfoRepository.getPokemonList(page = page)
}