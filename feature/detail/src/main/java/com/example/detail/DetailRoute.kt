package com.example.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.detail.common.DetailSideEffect
import com.example.ui.BaseSideEffect
import com.example.utils.showToast

@Composable
fun DetailRoute(
    pk: String,
    detailViewModel: DetailViewModel = hiltViewModel(),
    onStartHome: () -> Unit
) {
    val context = LocalContext.current
    val uiState by detailViewModel.state.collectAsState()
    val sideEffect = detailViewModel.effect

    LaunchedEffect(sideEffect) {
        sideEffect.collect { effect ->
            when (effect) {
                is DetailSideEffect.MoveTab -> { }
                is DetailSideEffect.SetLikeIcon -> { }
                is BaseSideEffect.ShowToast -> { context.showToast(message = effect.message) }
                is DetailSideEffect.StartHomePage -> { }
            }
        }
    }

    DetailScreen(
        uiState = uiState,
        onNavigateHome = onStartHome,
        onInit = { detailViewModel.getPokemonDetailInfo(id = pk.toIntOrNull() ?: 0) },
        onEvent = { event -> detailViewModel.setEvent(event) },
        onSideEffect = { effect -> detailViewModel.setEffect(effect) }
    )
}