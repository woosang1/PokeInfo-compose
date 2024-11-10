package com.example.home.common

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.paging.PagingData
import com.example.domain.model.Pokemon
import com.example.domain.model.PokemonList
import com.example.ui.State
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.Flow

@Stable
data class HomeState(
    val homeUiState : HomeUiState
): State

sealed class HomeUiState {
    data object Init : HomeUiState()
    data object Empty : HomeUiState()
    data class Result(val pokemonList: Flow<PagingData<Pokemon>>) : HomeUiState()
    data object Error : HomeUiState()
}