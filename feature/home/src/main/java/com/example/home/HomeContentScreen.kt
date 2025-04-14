package com.example.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.PagingContentHandler
import com.example.home.common.HomeEvent
import com.example.home.view.GridCardLayout
import com.example.model.ui.Pokemon
import kotlinx.coroutines.flow.Flow

@Composable
fun HomeContentScreen(
    pokemonList: Flow<PagingData<Pokemon>>,
    onEvent: (HomeEvent) -> Unit
) {
    val pokeList = pokemonList.collectAsLazyPagingItems()

    PagingContentHandler(
        items = pokeList,
        onError = { e -> onEvent(HomeEvent.PagingError(e = e)) },
        onEmpty = { },
        onLoading = { },
        content = {
            GridCardLayout(
                columns = 2,
                modifier = Modifier,
                paddingValues = 16,
                horizontalArrangement = 8,
                verticalArrangement = 8,
                cardList = pokeList,
                onClickPokemonCard = { pokemon ->
                    onEvent.invoke(HomeEvent.ClickPokemonCard(pokemon = pokemon))
                }
            )
        }
    )

}