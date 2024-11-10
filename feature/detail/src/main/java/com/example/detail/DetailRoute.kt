package com.example.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.detail.common.DetailSideEffect

@Composable
fun DetailRoute(
    detailViewModel: DetailViewModel = hiltViewModel(),
    onStartHome: () -> Unit
) {
    val context = LocalContext.current
    val uiState by detailViewModel.uiState.collectAsState()
    val sideEffect = detailViewModel.effect

    LaunchedEffect(sideEffect) {
        sideEffect.collect { effect ->
            when (effect) {
                is DetailSideEffect.MoveTab -> { }
                is DetailSideEffect.SetLikeIcon -> { }
                is DetailSideEffect.ShowToast -> { }
                is DetailSideEffect.StartHomePage -> { }
            }
        }
    }

    DetailScreen(
        uiState = uiState,
        detailViewModel = detailViewModel,
        onNavigateHome = onStartHome
    )
}