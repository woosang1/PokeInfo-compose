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
    homeViewModel: HomeViewModel = hiltViewModel()
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
                is HomeSideEffect.StartDetailActivity -> { }
            }
        }
    }

    HomeScreen(
        uiState = uiState,
        onClickPokemonCard = { pokemonInfo ->
            homeViewModel.setEvent(MainEvent.ClickPokemonCard(pokemonInfo = pokemonInfo))
        }
    )
}