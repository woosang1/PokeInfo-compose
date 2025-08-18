package com.example.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.home.common.HomeEvent
import com.example.home.component.GridCardLayout
import com.example.model.ui.Pokemon
import com.example.utils.PagingContentHandler
import kotlinx.coroutines.flow.Flow

@Composable
fun HomeContentScreen(
    pokemonList: Flow<PagingData<Pokemon>>,
    isDualScreen: Boolean,
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
                columns = if (isDualScreen) 3 else 2,
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