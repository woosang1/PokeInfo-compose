package com.example.detail.common

import androidx.compose.runtime.Stable
import com.example.domain.model.Pokemon
import com.example.ui.State
import kotlinx.coroutines.flow.Flow

@Stable
data class DetailState(
    val detailUiState : DetailUiState
): State

sealed class DetailUiState {
    data object Init : DetailUiState()
    data object Result : DetailUiState()
    data object Empty : DetailUiState()
    data object Error : DetailUiState()
}