package com.example.home.common

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.paging.PagingData
import com.example.base.mvi.State
import com.example.model.ui.Pokemon
import kotlinx.coroutines.flow.Flow

@Immutable
data class HomeState(
    val homeUiState : HomeUiState
): State

@Stable
sealed interface HomeUiState {
    data object Init : HomeUiState
    data class Content(
        val pokemonList: Flow<PagingData<Pokemon>>
    ) : HomeUiState
    data object Error : HomeUiState
}