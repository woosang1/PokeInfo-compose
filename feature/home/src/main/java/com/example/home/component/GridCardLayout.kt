package com.example.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.component.PokemonCard
import com.example.designsystem.theme.PokeInfoTheme
import com.example.utils.extension.dpToPixel
import com.example.utils.extension.getWidthDisplay
import com.example.model.ui.Pokemon

@Composable
internal fun GridCardLayout(
    columns: Int,
    modifier: Modifier,
    paddingValues: Int,
    horizontalArrangement: Int,
    verticalArrangement: Int,
    cardList: LazyPagingItems<Pokemon>,
    onClickPokemonCard: (Pokemon) -> Unit,
) {
    val gridState = rememberLazyGridState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = modifier,
        state = gridState,
        contentPadding = PaddingValues(paddingValues.dp),
        horizontalArrangement = Arrangement.spacedBy(horizontalArrangement.dp),
        verticalArrangement = Arrangement.spacedBy(verticalArrangement.dp)
    ) {
        items(cardList.itemCount) { index ->
            cardList[index]?.let { pokemon ->
                val cardWidth = ((LocalContext.current.getWidthDisplay() - 32.dpToPixel()) - 8.dpToPixel()) / 2
                PokemonCard(
                    modifier = Modifier
                        .width(cardWidth.dp)
                        .height(120.dp)
                        .padding(8.dp),
                    width = cardWidth,
                    height = 120,
                    pokemon = pokemon,
                    onClickPokemonCard = { pokemon ->
                        onClickPokemonCard.invoke(pokemon)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun Test() {
    PokeInfoTheme {
//        val defaultPokemon = com.example.model.ui.Pokemon()
//        GridCardLayout(
//            columns = 2,
//            modifier = Modifier,
//            paddingValues = 16,
//            horizontalArrangement = 8,
//            verticalArrangement = 8,
//            cardList = ArrayList<Pokemon>().apply {
//                add(defaultPokemon)
//                add(defaultPokemon)
//            }.toImmutableList(),
//            onClickPokemonCard = { }
//        )
    }
}