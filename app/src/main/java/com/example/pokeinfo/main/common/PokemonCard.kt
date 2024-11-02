package com.example.pokeinfo.main.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.R

@Composable
fun PokemonCard(pokemonInfo: PokemonInfo) {
    val backgroundColor = Color.Green
//        val backgroundColor = when (pokemonInfo.type) {
//            "Grass" -> Color.Green // Adjust based on type
//            "Fire" -> Color.Red // Adjust based on type
//            else -> Color.Gray // Default color
//        }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(8.dp)
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = pokemonInfo.name,
                color = Color.White,
//                    style = FontStyle.MEDIUM // Adjust font style
            )
            Text(
                text = "#${pokemonInfo.id}",
                color = Color.White.copy(alpha = 0.25f),
//                    style = FontStyle.BOLD // Adjust font style
            )
            Text(
                text = pokemonInfo.type[0],
                color = Color.White,
                modifier = Modifier
//                        .background(R.drawable.background_item_pokemon_span)
                    .padding(horizontal = 8.dp)
            )
            Text(
                text = pokemonInfo.type[1],
                color = Color.White,
                modifier = Modifier
//                        .background(R.drawable.background_item_pokemon_span)
                    .padding(horizontal = 8.dp)
            )
            Text(
                text = pokemonInfo.type[2],
                color = Color.White,
                modifier = Modifier
//                        .background(R.drawable.background_item_pokemon_span)
                    .padding(horizontal = 8.dp)
            )
        }

//        Image(
//            painter = painterResource(id = com.example.pokeinfo.R.drawable.pokeball),
//            contentDescription = null,
//            modifier = Modifier
//                .size(96.dp)
//                .align(Alignment.BottomEnd)
//                .padding(end = 16.dp, bottom = 24.dp)
//                .alpha(0.25f)
//        )
//
//        Image(
//            painter = rememberImagePainter(pokemonInfo.image),
//            contentDescription = null,
//            modifier = Modifier
//                .size(80.dp)
//                .align(Alignment.BottomEnd)
//                .padding(end = 16.dp)
//        )

    }
}