package com.example.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.domain.model.PokemonInfo
import com.example.home.common.HomeState
import com.example.home.common.HomeUiState
import com.example.home.component.GridCardLayout

@Composable
fun HomeScreen(
    uiState: HomeState,
    onClickPokemonCard: (PokemonInfo) -> Unit,
) {
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
                    onClickPokemonCard.invoke(pokemonInfo)
                }
            )
        }
        is HomeUiState.Error -> { }
    }
}