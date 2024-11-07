package com.example.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.main.common.MainEvent
import com.example.main.common.MainSideEffect
import com.example.main.common.MainUiState
import com.example.main.component.GridCardLayout
import com.example.utils.showToast

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val uiState by mainViewModel.uiState.collectAsState()
    val sideEffect = mainViewModel.effect
    val context = LocalContext.current

    LaunchedEffect(sideEffect) {
        sideEffect.collect { effect ->
            when (effect) {
                is MainSideEffect.CloseBottomSheet -> {}
                is MainSideEffect.ShowAllTypeBottomSheet -> {}
                is MainSideEffect.ShowFavoriteBottomSheet -> {}
                is MainSideEffect.ShowGenerationsBottomSheet -> {}
                is MainSideEffect.ShowSearchBottomSheet -> {}
                is MainSideEffect.ShowToast -> { context.showToast(effect.message) }
                is MainSideEffect.StartDetailActivity -> { }
            }
        }
    }

    when(val mainUiState = uiState.mainUiState){
        is MainUiState.Empty -> { }
        is MainUiState.Result -> {
            GridCardLayout(
                columns = 2,
                modifier = Modifier,
                paddingValues = 16,
                horizontalArrangement = 8,
                verticalArrangement = 8,
                cardList = mainUiState.pokemonList,
                onClickPokemonCard = { pokemonInfo ->
                    mainViewModel.setEvent(MainEvent.ClickPokemonCard(pokemonInfo = pokemonInfo))
                }
            )
        }
        is MainUiState.Error -> { }
    }
}