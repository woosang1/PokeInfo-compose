package com.example.main.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.PokeInfoTheme
import com.example.domain.model.PokemonInfo
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.platform.LocalContext
import com.example.utils.dpToPixel
import com.example.utils.getWidthDisplay

@Composable
fun GridCardLayout(
    columns: Int,
    modifier: Modifier,
    paddingValues: Int,
    horizontalArrangement: Int,
    verticalArrangement: Int,
    cardList: ImmutableList<PokemonInfo>,
    onClickPokemonCard: (PokemonInfo) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = modifier,
        contentPadding = PaddingValues(paddingValues.dp),
        horizontalArrangement = Arrangement.spacedBy(horizontalArrangement.dp),
        verticalArrangement = Arrangement.spacedBy(verticalArrangement.dp)
    ) {
        items(cardList.size) { index ->
            val cardWidth = ((LocalContext.current.getWidthDisplay() - 32.dpToPixel()) - 8.dpToPixel()) / 2
            PokemonCard(
                modifier = Modifier
                    .width(cardWidth.dp)
                    .height(120.dp)
                    .padding(8.dp),
                width = cardWidth,
                height = 120,
                pokemonInfo = cardList[index],
                onClickPokemonCard = { pokemonInfo ->
                    onClickPokemonCard.invoke(pokemonInfo)
                }
            )
        }
    }
}

@Preview
@Composable
fun Test() {
    PokeInfoTheme {
        val defaultPokemon = PokemonInfo(
            id = "000",
            name = "Unknown",
            image = "https://example.com/unknown.png",
            type = emptyList(),
            abilities = emptyList(),
            attack = 50,
            baseExp = "0",
            category = "Unknown",
            cycles = "Unknown",
            defense = 50,
            eggGroups = "Unknown",
            evolutions = null,
            evolvedfrom = "None",
            femalePercentage = "50%",
            genderless = 0,
            height = "0.0 m",
            hp = 50,
            malePercentage = "50%",
            reason = "None",
            specialAttack = 50,
            specialDefense = 50,
            speed = 50,
            total = 300,
            typeofpokemon = emptyList(),
            weaknesses = emptyList(),
            weight = "0.0 kg",
            xdescription = "No description available.",
            ydescription = "No description available."
        )

        GridCardLayout(
            columns = 2,
            modifier = Modifier,
            paddingValues = 16,
            horizontalArrangement = 8,
            verticalArrangement = 8,
            cardList = ArrayList<PokemonInfo>().apply {
                add(defaultPokemon)
                add(defaultPokemon)
            }.toImmutableList(),
            onClickPokemonCard = { }
        )
    }
}