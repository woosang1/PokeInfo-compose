package com.example.home.common

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.paging.PagingData
import com.example.model.ui.Pokemon
import com.example.base.mvi.State
import kotlinx.coroutines.flow.Flow

@Immutable
data class HomeState(
    val homeUiState : HomeUiState
): State

@Stable
sealed interface HomeUiState {
    data object Loading : HomeUiState
    data object Empty : HomeUiState
    data class Success(val pokemonList: Flow<PagingData<Pokemon>>) : HomeUiState
}