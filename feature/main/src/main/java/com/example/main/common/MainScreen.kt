package com.example.main.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.example.main.MainViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.model.PokemonInfo
import com.example.main.common.views.GridCardLayout
import kotlinx.collections.immutable.ImmutableList

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel<MainViewModel>()
) {
    val uiState by mainViewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(mainViewModel.effect) {
        mainViewModel.effect.collect { effect ->
            when (effect) {
                is MainSideEffect.CloseBottomSheet -> {}
                is MainSideEffect.ShowAllTypeBottomSheet -> {}
                is MainSideEffect.ShowFavoriteBottomSheet -> {}
                is MainSideEffect.ShowGenerationsBottomSheet -> {}
                is MainSideEffect.ShowSearchBottomSheet -> {}
                is MainSideEffect.ShowToast -> {}
                is MainSideEffect.StartDetailActivity -> {}
            }
        }
    }
    when(val mainUiState = uiState.mainUiState){
        is MainUiState.Empty -> { }
        is MainUiState.Result -> {
            GridCardLayout(cardList = mainUiState.pokemonList)
        }
        is MainUiState.Error -> { }
    }
}