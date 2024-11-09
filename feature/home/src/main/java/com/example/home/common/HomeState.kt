package com.example.home.common

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.domain.model.PokemonInfo
import com.example.ui.State
import kotlinx.collections.immutable.ImmutableList

@Stable
data class HomeState(
    val homeUiState : HomeUiState
): State

sealed class HomeUiState {
    data object Init : HomeUiState()
    data object Empty : HomeUiState()
    @Immutable
    data class Result(val pokemonList: ImmutableList<PokemonInfo.Pokemon>) : HomeUiState()
    data object Error : HomeUiState()
}