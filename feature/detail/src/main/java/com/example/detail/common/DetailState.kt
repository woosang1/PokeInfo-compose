package com.example.detail.common

import androidx.compose.runtime.Stable
import com.example.ui.State

@Stable
data class DetailState(
    val detailUiState : DetailUiState
): State

sealed class DetailUiState {
    data object Init : DetailUiState()
    data object Empty : DetailUiState()
    data object Error : DetailUiState()
}