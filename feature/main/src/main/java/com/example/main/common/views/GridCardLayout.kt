package com.example.main.common.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.PokeInfoTheme
import com.example.domain.model.PokemonInfo
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun GridCardLayout(cardList: ImmutableList<PokemonInfo>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(cardList.chunked(2)) { rowItems ->
            val (left, right) = rowItems
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                PokemonCard(left)
                Spacer(modifier = Modifier.width(8.dp))
                PokemonCard(right)
            }
        }
    }
}

@Preview
@Composable
fun Test(){
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
        GridCardLayout(cardList = ArrayList<PokemonInfo>().apply {
            add(defaultPokemon)
            add(defaultPokemon)
        }.toImmutableList())
    }
}