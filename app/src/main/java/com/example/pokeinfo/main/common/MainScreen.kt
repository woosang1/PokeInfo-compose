package com.example.pokeinfo.main.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.main.MainViewModel
//import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = MainViewModel()
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
    when(uiState.mainUiState){
        is MainUiState.Empty -> { }
        is MainUiState.Result -> { }
        is MainUiState.Error -> { }
    }
}