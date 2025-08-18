package com.example.detail.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.detail.detail.common.DetailSideEffect
import com.example.utils.UiError
import com.example.utils.extension.showToast

@Composable
fun DetailRoute(
    pk: String,
    detailViewModel: DetailViewModel = hiltViewModel(),
    onBackEvent: () -> Unit
) {
    val context = LocalContext.current
    val uiState by detailViewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        detailViewModel.effect.collect { effect ->
            when (effect) {
                is DetailSideEffect.MoveTab -> { }
                is DetailSideEffect.SetLikeIcon -> { }
                is DetailSideEffect.ShowToast -> { context.showToast(message = effect.message) }
                is DetailSideEffect.NavigateBack -> { onBackEvent() }
                is DetailSideEffect.HandleNetworkUI -> {
                    context.showToast(effect.uiError.message)
                    when(effect.uiError){
                        is UiError.AuthError -> Unit
                        is UiError.NetworkError -> Unit
                        is UiError.PermissionError -> Unit
                        is UiError.ServerError -> Unit
                        is UiError.UnknownError -> Unit
                    }
                }
            }
        }
    }

    DetailScreen(
        uiState = uiState,
        onInit = { detailViewModel.getPokemonDetailInfo(id = pk.toIntOrNull() ?: 0) },
        onEvent = { event -> detailViewModel.setEvent(event) }
    )
}