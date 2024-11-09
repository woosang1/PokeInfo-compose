package com.example.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.home.common.HomeSideEffect
import com.example.home.common.MainEvent
import com.example.utils.showToast

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onStartDetail: () -> Unit,
) {
    val context = LocalContext.current
    val uiState by homeViewModel.uiState.collectAsState()
    val sideEffect = homeViewModel.effect

    LaunchedEffect(sideEffect) {
        sideEffect.collect { effect ->
            when (effect) {
                is HomeSideEffect.CloseBottomSheet -> {}
                is HomeSideEffect.ShowAllTypeBottomSheet -> {}
                is HomeSideEffect.ShowFavoriteBottomSheet -> {}
                is HomeSideEffect.ShowGenerationsBottomSheet -> {}
                is HomeSideEffect.ShowSearchBottomSheet -> {}
                is HomeSideEffect.ShowToast -> { context.showToast(effect.message) }
                is HomeSideEffect.StartDetailActivity -> { onStartDetail.invoke() }
            }
        }
    }

    HomeScreen(
        uiState = uiState,
        initAction = {
            homeViewModel.getPokemonList(
                limit = 0,
                offset = 0,
            )
        },
        onClickPokemonCard = { pokemon ->
            homeViewModel.setEvent(MainEvent.ClickPokemonCard(pokemon = pokemon))
        }
    )
}