package com.example.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.request.CachePolicy
import com.example.component.common.getPokemonColorType
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.model.ui.Pokemon
import com.example.utils.extension.noRippleClickable

@Composable
fun PokemonCard(
    modifier: Modifier,
    width: Dp,
    height: Dp,
    pokemon: Pokemon,
    onClickPokemonCard: (Pokemon) -> Unit,
) {
    // 성능 최적화: remember를 사용하여 불필요한 재계산 방지
    val cardShape = remember { RoundedCornerShape(16.dp) }
    val latestClick = rememberUpdatedState(newValue = onClickPokemonCard)
    val clickableModifier = remember(pokemon.id) {
        Modifier
            .clip(cardShape)
            .noRippleClickable {
                latestClick.value.invoke(pokemon)
            }
    }
    val imageSize = remember { 80.dp }
    val circleShape = remember { CircleShape }

    Box(
        modifier = modifier.then(clickableModifier)
    ) {
        // 배경 이미지
        Box(
            modifier = Modifier
                .size(width = width, height = height)
                .background(LocalColors.current.purple80)
        )

        // 내용
        Box(modifier = Modifier.padding(8.dp)) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // 이름 텍스트
                    PKText(
                        text = pokemon.name,
                        modifier = Modifier
                            .weight(1f),
                        textAlign = TextAlign.Start,
                        style = LocalTypography.current.body1,
                        color = LocalColors.current.white,
                        maxLines = 1
                    )

                    // ID 텍스트
                    PKText(
                        text = "#${pokemon.id}",
                        modifier = Modifier
                            .weight(1f),
                        textAlign = TextAlign.End,
                        style = LocalTypography.current.subTitle,
                        color = LocalColors.current.white.copy(
                            alpha = 0.75f
                        ),
                        maxLines = 1
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // 타입들을 세로로 나열 (썸네일을 가리지 않도록)
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    pokemon.types.take(2).forEach { type ->
                        TypeChip(
                            type = type,
                            modifier = Modifier
                        )
                    }
                }
            }

            PKImage(
                data = pokemon.thumbnailUrl,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(imageSize),
                clipShape = circleShape,
                contentScale = ContentScale.Crop,
                requestBuilder = {
                    crossfade(true)
                    diskCachePolicy(CachePolicy.ENABLED)
                    memoryCachePolicy(CachePolicy.ENABLED)
                }
            )

        }
    }
}

@Composable
private fun TypeChip(
    type: String,
    modifier: Modifier = Modifier
) {
    val typeColor = remember(type) { type.getPokemonColorType() }
    val chipShape = remember { RoundedCornerShape(12.dp) }
    
    Box(
        modifier = modifier
            .clip(chipShape)
            .background(typeColor.copy(alpha = 0.8f))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        PKText(
            text = type.replaceFirstChar { it.uppercase() },
            style = LocalTypography.current.caption1.copy(
                fontWeight = FontWeight.Medium
            ),
            color = Color.White,
            maxLines = 1
        )
    }
}