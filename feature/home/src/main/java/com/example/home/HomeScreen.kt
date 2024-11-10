package com.example.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.designsystem.theme.LocalColors
import com.example.domain.model.Pokemon
import com.example.home.common.HomeState
import com.example.home.common.HomeUiState
import com.example.home.component.GridCardLayout
import com.example.log.DebugLog

@Composable
fun HomeScreen(
    uiState: HomeState,
    initAction:() -> Unit,
    onClickPokemonCard: (Pokemon) -> Unit,
) {
    when(val mainUiState = uiState.homeUiState){
        is HomeUiState.Init -> {
            DebugLog("is HomeUiState.Init ->")
            initAction.invoke()
        }
        is HomeUiState.Empty -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(LocalColors.current.black)
            ) {  }
        }
        is HomeUiState.Result -> {
            GridCardLayout(
                columns = 2,
                modifier = Modifier,
                paddingValues = 16,
                horizontalArrangement = 8,
                verticalArrangement = 8,
                cardList = mainUiState.pokemonList.collectAsLazyPagingItems(),
                onClickPokemonCard = { pokemon ->
                    onClickPokemonCard.invoke(pokemon)
                }
            )
        }
        is HomeUiState.Error -> { }
    }
}