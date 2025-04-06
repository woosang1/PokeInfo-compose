package com.example.detail.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.detail.detail.common.DetailSideEffect
import com.example.base.base.BaseSideEffect
import com.example.extension.showToast
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DetailRoute(
    pk: String,
    detailViewModel: DetailViewModel = hiltViewModel(),
    onBackEvent: () -> Unit
) {
    val context = LocalContext.current
    val uiState by detailViewModel.state.collectAsStateWithLifecycle()
    val sideEffect = detailViewModel.effect

    LaunchedEffect(sideEffect) {
        sideEffect.collect { effect ->
            when (effect) {
                is DetailSideEffect.MoveTab -> { }
                is DetailSideEffect.SetLikeIcon -> { }
                is BaseSideEffect.ShowToast -> { context.showToast(message = effect.message) }
                is DetailSideEffect.BackPage -> { onBackEvent.invoke() }
            }
        }
    }

    DetailScreen(
        uiState = uiState,
        onInit = { detailViewModel.getPokemonDetailInfo(id = pk.toIntOrNull() ?: 0) },
        onEvent = { event -> detailViewModel.setEvent(event) }
    )
}