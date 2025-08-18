package com.example.detail.evolution

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.model.ui.EvolutionModel

@Composable
fun EvolutionRoute(
    model: EvolutionModel?
) {
    val context = LocalContext.current

    EvolutionScreen(
        spriteImageUrl = model?.spriteImageUrl ?: "",
        spritesShinyImageUrl = model?.spritesShinyImageUrl ?: ""
    )
}

@Composable
fun EvolutionScreen(
    spriteImageUrl: String,
    spritesShinyImageUrl: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = spriteImageUrl,
                contentDescription = "Normal Sprite",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "기본",
                modifier = Modifier.padding(top = 8.dp),
                style = LocalTypography.current.headline3,
                color = LocalColors.current.black,
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = spritesShinyImageUrl,
                contentDescription = "Shiny Sprite",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "이로치",
                modifier = Modifier.padding(top = 8.dp),
                style = LocalTypography.current.headline3,
                color = LocalColors.current.black,
                textAlign = TextAlign.Center
            )
        }
    }
}
