package com.example.detail.common

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.domain.model.Pokemon
import com.example.mvi.State

@Immutable
data class DetailState(
    val detailUiState : DetailUiState
): State

@Stable
sealed interface DetailUiState {
    data object Loading : DetailUiState
    data class Result(
        val pokemon: Pokemon
    ) : DetailUiState
    data object Empty : DetailUiState
}