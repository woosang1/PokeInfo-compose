package com.example.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.utils.extension.noRippleClickable
import com.example.model.ui.Pokemon
import com.example.resource.R as ResourceR

@Composable
fun PokemonCard(
    modifier: Modifier,
    width: Int,
    height: Int,
    pokemon: Pokemon,
    onClickPokemonCard: (Pokemon) -> Unit,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .noRippleClickable {
                onClickPokemonCard.invoke(pokemon)
            }
    ) {
        // 배경 이미지
        Box(
            modifier = Modifier
                .width(width.dp)
                .height(height.dp)
                .background(LocalColors.current.purple80)
        )

        // 내용
        Box(modifier = Modifier.padding(8.dp)) {
            Column {
                Row {
                    // 이름 텍스트
                    Text(
                        text = pokemon.name,
                        modifier = Modifier
                            .weight(1f),
                        textAlign = TextAlign.Start,
                        style = LocalTypography.current.body1,
                        color = LocalColors.current.white,
                        maxLines = 1
                    )

                    // ID 텍스트
                    Text(
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

                // Type1 텍스트
                Text(
                    text = "타입1",
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .align(Alignment.Start),
                    style = LocalTypography.current.subTitle,
                    color = LocalColors.current.white,
                    maxLines = 1
                )

                // Type2 텍스트
                Text(
                    text = "타입2",
                    modifier = Modifier
                        .padding(start = 8.dp, top = 4.dp, end = 8.dp)
                        .align(Alignment.Start),
                    style = LocalTypography.current.subTitle,
                    color = LocalColors.current.white,
                    maxLines = 1
                )
            }

            // 이미지를 오른쪽 하단에 배치
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            ) {
                AsyncImage(
                    model = pokemon.url,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    placeholder = null
                )
            }

//             Pokeball 이미지 (배경에 흐리게 배치)
            Image(
                painter = painterResource(id = ResourceR.drawable.pokeball),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(96.dp)
                    .offset(x = 25.dp, y = 25.dp)
                    .alpha(0.25f),
                contentScale = ContentScale.Fit
            )
        }
    }
}