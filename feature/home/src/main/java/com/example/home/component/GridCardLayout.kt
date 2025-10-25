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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.component.PokemonCard
import com.example.designsystem.theme.PokeInfoTheme
import com.example.model.ui.Pokemon
import com.example.utils.extension.dpToPixel
import com.example.utils.extension.getWidthDisplay

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
    val context = LocalContext.current
    val gridState = rememberLazyGridState()
    
    // 성능 최적화: 카드 크기 계산을 remember로 캐싱
    val cardWidth = remember(columns) {
        ((context.getWidthDisplay() - 32.dpToPixel()) - 8.dpToPixel()) / columns
    }
    val cardHeight = remember { 120 }
    
    // 성능 최적화: GridCells와 Arrangement를 remember로 캐싱
    val gridCells = remember(columns) { GridCells.Fixed(columns) }
    val horizontalArrangementSpaced = remember(horizontalArrangement) {
        Arrangement.spacedBy(horizontalArrangement.dp)
    }
    val verticalArrangementSpaced = remember(verticalArrangement) {
        Arrangement.spacedBy(verticalArrangement.dp)
    }

    LazyVerticalGrid(
        columns = gridCells,
        modifier = modifier,
        state = gridState,
        contentPadding = PaddingValues(paddingValues.dp),
        horizontalArrangement = horizontalArrangementSpaced,
        verticalArrangement = verticalArrangementSpaced
    ) {
        items(cardList.itemCount) { index ->
            cardList[index]?.let { pokemon ->
                PokemonCard(
                    modifier = Modifier
                        .width(cardWidth.dp)
                        .height(cardHeight.dp)
                        .padding(8.dp),
                    width = cardWidth,
                    height = cardHeight,
                    pokemon = pokemon,
                    onClickPokemonCard = onClickPokemonCard
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