package com.example.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.home.common.MainEvent
import com.example.home.common.HomeSideEffect
import com.example.home.common.HomeUiState
import com.example.home.component.GridCardLayout
import com.example.utils.showToast

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel
) {
    val uiState by homeViewModel.uiState.collectAsState()
    val sideEffect = homeViewModel.effect
    val context = LocalContext.current

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

    when(val mainUiState = uiState.homeUiState){
        is HomeUiState.Empty -> { }
        is HomeUiState.Result -> {
            GridCardLayout(
                columns = 2,
                modifier = Modifier,
                paddingValues = 16,
                horizontalArrangement = 8,
                verticalArrangement = 8,
                cardList = mainUiState.pokemonList,
                onClickPokemonCard = { pokemonInfo ->
                    homeViewModel.setEvent(MainEvent.ClickPokemonCard(pokemonInfo = pokemonInfo))
                }
            )
        }
        is HomeUiState.Error -> { }
    }
}