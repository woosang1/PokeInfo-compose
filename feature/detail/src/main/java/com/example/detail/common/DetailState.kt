package com.example.detail.common

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.model.ui.Pokemon
import com.example.base.mvi.State

@Immutable
data class DetailState(
    val detailUiState : DetailUiState
): com.example.base.mvi.State

@Stable
sealed interface DetailUiState {
    data object Loading : DetailUiState
    data class Result(
        val pokemon: com.example.model.ui.Pokemon
    ) : DetailUiState
    data object Empty : DetailUiState
}