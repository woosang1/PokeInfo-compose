package com.example.detail.common

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.mvi.State

@Immutable
data class DetailState(
    val detailUiState : DetailUiState
): State

@Stable
sealed interface DetailUiState {
    data object Loading : DetailUiState
    data object Result : DetailUiState
    data object Empty : DetailUiState
}