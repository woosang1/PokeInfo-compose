package com.example.detail.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.detail.detail.common.DetailSideEffect
import com.example.utils.extension.showToast

@Composable
fun DetailRoute(
    pk: String,
    detailViewModel: DetailViewModel = hiltViewModel(),
    onBackEvent: () -> Unit,
    onHandleNetworkUI: (throwable: Throwable?) -> Unit
) {
    val context = LocalContext.current
    val uiState by detailViewModel.state.collectAsStateWithLifecycle()
    val sideEffect = detailViewModel.effect

    LaunchedEffect(sideEffect) {
        sideEffect.collect { effect ->
            when (effect) {
                is DetailSideEffect.MoveTab -> { }
                is DetailSideEffect.SetLikeIcon -> { }
                is DetailSideEffect.ShowToast -> { context.showToast(message = effect.message) }
                is DetailSideEffect.BackPage -> { onBackEvent.invoke() }
                is DetailSideEffect.HandleNetworkUI -> { onHandleNetworkUI(effect.throwable) }
            }
        }
    }

    DetailScreen(
        uiState = uiState,
        onInit = { detailViewModel.getPokemonDetailInfo(id = pk.toIntOrNull() ?: 0) },
        onEvent = { event -> detailViewModel.setEvent(event) }
    )
}