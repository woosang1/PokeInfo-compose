package com.example.domain.usecase

import com.example.data.repository.PokemonRepository
import com.example.model.ui.Pokemon
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonDetailInfoUseCaseImpl @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : GetPokemonDetailInfoUseCase {
    override suspend operator fun invoke(id: Int): Pokemon =
        combine(
            flow { emit(pokemonRepository.getPokemonInfo(id)) },
            flow { emit(pokemonRepository.getPokemonSpeciesInfo(id)) }
        ) { info, species ->
            info.mergeWith(species)
        }.first()
}

fun Pokemon.mergeWith(other: Pokemon): Pokemon {
    return this.copy(
        color = other.color.takeIf { it.isNotEmpty() } ?: this.color,
        description = other.description.takeIf { it.isNotEmpty() } ?: this.description,
        genderRate = other.genderRate.takeIf { it != Pair(0.0, 0.0) } ?: this.genderRate,
        eggGroups = other.eggGroups.takeIf { it.isNotEmpty() } ?: this.eggGroups,
        eggCycle = other.eggCycle.takeIf { it != 0 } ?: this.eggCycle
    )
}