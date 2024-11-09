package com.example.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.domain.model.PokemonInfo
import coil.compose.rememberAsyncImagePainter
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.utils.noRippleClickable
import com.example.utils.setImageUrl
//import com.example.ui.R

@Composable
fun PokemonCard(
    modifier: Modifier,
    width: Int,
    height: Int,
    pokemonInfo: PokemonInfo,
    onClickPokemonCard: (PokemonInfo) -> Unit,
) {
    Box(
        modifier = modifier
            .noRippleClickable {
                onClickPokemonCard.invoke(pokemonInfo)
            }
    ) {
        // 배경 이미지
        Image(
            painter = rememberAsyncImagePainter(
                model = LocalContext.current.setImageUrl(
//                    data = pokemonInfo.type,
                    data = "",
                    width = width,
                    height = height
                )
            ),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        // 내용
        Box(modifier = Modifier.padding(8.dp)) {
            Column {
                // 이름 텍스트
                Text(
                    text = pokemonInfo.name,
                    modifier = Modifier
                        .align(Alignment.Start),
                    textAlign = TextAlign.Center,
                    style = LocalTypography.current.title4,
                    color = LocalColors.current.white,
                    maxLines = 1
                )

                // ID 텍스트
                Text(
                    text = "#${pokemonInfo.id}",
                    modifier = Modifier
                        .align(Alignment.End),
                    style = LocalTypography.current.title4,
                    color = LocalColors.current.white.copy(
                        alpha = 0.25f
                    ),
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Type1 텍스트
                Text(
                    text = pokemonInfo.type[0],
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(Alignment.Start),
                    style = LocalTypography.current.title4,
                    color = LocalColors.current.white,
                    maxLines = 1
                )

                // Type2 텍스트
                Text(
                    text = pokemonInfo.type[1],
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(Alignment.Start),
                    style = LocalTypography.current.title4,
                    color = LocalColors.current.white,
                    maxLines = 1
                )

                // Type3 텍스트 (옵션)
                Text(
                    text = pokemonInfo.type[1],
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(Alignment.Start),
                    style = LocalTypography.current.title4,
                    color = LocalColors.current.white,
                    maxLines = 1
                )
            }

            // 이미지를 오른쪽 하단에 배치
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 16.dp, end = 16.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = LocalContext.current.setImageUrl(
                            data = pokemonInfo.image,
                            width = 80,
                            height = 80
                        )
                    ),
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }

            // Pokeball 이미지 (배경에 흐리게 배치)
//            Image(
//                painter = painterResource(id = R.drawable.pokeball),
//                contentDescription = null,
//                modifier = Modifier
//                    .align(Alignment.BottomEnd)
//                    .padding(end = 16.dp, bottom = 24.dp)
//                    .size(96.dp)
//                    .alpha(0.25f),
//                contentScale = ContentScale.Fit
//            )
        }
    }
}