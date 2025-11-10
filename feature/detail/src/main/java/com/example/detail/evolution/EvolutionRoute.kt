package com.example.detail.evolution

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.component.PKImage
import com.example.component.PKText
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
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(
                        LocalColors.current.gray.copy(alpha = 0.1f),
                        RoundedCornerShape(12.dp)
                    )
                    .padding(8.dp)
            ) {
                PKImage(
                    data = spriteImageUrl,
                    contentDescription = "Normal Sprite",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
            PKText(
                text = "기본",
                modifier = Modifier.padding(top = 8.dp),
                style = LocalTypography.current.body1,
                color = LocalColors.current.black,
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(
                        LocalColors.current.gray.copy(alpha = 0.1f),
                        RoundedCornerShape(12.dp)
                    )
                    .padding(8.dp)
            ) {
                PKImage(
                    data = spritesShinyImageUrl,
                    contentDescription = "Shiny Sprite",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
            PKText(
                text = "이로치",
                modifier = Modifier.padding(top = 8.dp),
                style = LocalTypography.current.body1,
                color = LocalColors.current.black,
                textAlign = TextAlign.Center
            )
        }
    }
}
