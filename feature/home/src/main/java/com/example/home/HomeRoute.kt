package com.example.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.home.common.HomeSideEffect
import com.example.base.base.BaseSideEffect
import com.example.extension.showToast

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onClickItem: (String) -> Unit,
) {
    val context = LocalContext.current
    val uiState by homeViewModel.state.collectAsStateWithLifecycle()
    val sideEffect = homeViewModel.effect

    LaunchedEffect(sideEffect) {
        sideEffect.collect { effect ->
            when (effect) {
                is HomeSideEffect.CloseBottomSheet -> {}
                is HomeSideEffect.ShowAllTypeBottomSheet -> {}
                is HomeSideEffect.ShowFavoriteBottomSheet -> {}
                is HomeSideEffect.ShowGenerationsBottomSheet -> {}
                is HomeSideEffect.ShowSearchBottomSheet -> {}
                is BaseSideEffect.ShowToast -> { context.showToast(effect.message) }
                is HomeSideEffect.StartDetailActivity -> { onClickItem.invoke(effect.pokemon.id.toString()) }
            }
        }
    }

    HomeScreen(
        uiState = uiState,
        onInit = { homeViewModel.checkLoading() },
        onEvent = { event -> homeViewModel.setEvent(event) }
    )
}