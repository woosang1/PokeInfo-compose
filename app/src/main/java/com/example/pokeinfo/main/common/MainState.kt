package com.example.pokeinfo.main.common

import androidx.compose.runtime.Immutable
import com.example.domain.model.PokemonInfo
import com.example.ui.State
import kotlinx.collections.immutable.ImmutableList

data class MainState(
    val mainUiState : MainUiState
): State

sealed class MainUiState {
    data object Empty : MainUiState()
    @Immutable
    data class Result(val pokemonList: ImmutableList<PokemonInfo>) : MainUiState()
    data object Error : MainUiState()
}