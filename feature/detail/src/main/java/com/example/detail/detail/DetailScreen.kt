package com.example.detail.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.component.LoadingAnimation
import com.example.component.common.getPokemonColorByColor
import com.example.designsystem.theme.LocalColors
import com.example.detail.detail.common.DetailEvent
import com.example.detail.detail.common.DetailState
import com.example.detail.detail.common.DetailUiState
import com.example.utils.extension.noRippleClickable
import com.example.utils.log.DebugLog
import com.example.resource.R as ResourceR

@Composable
fun DetailScreen(
    uiState: DetailState,
    onInit: () -> Unit,
    onEvent: (DetailEvent) -> Unit
) {
    LaunchedEffect(Unit) {
        DebugLog("DetailScreen - LaunchedEffect(Unit)")
        onInit.invoke()
    }

    val isShowToolbar = remember(uiState.detailUiState) {
        uiState.detailUiState is DetailUiState.Result
    }

    val backgroundColor = when (val state = uiState.detailUiState) {
        is DetailUiState.Result -> state.pokemon.color.getPokemonColorByColor().copy(alpha = 0.5f)
        else -> LocalColors.current.purple80
    }

    val isLike = when (val state = uiState.detailUiState) {
        is DetailUiState.Result -> state.pokemon.isLike
        else -> false
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.Start
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .alpha(if (isShowToolbar) 1f else 0f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = ResourceR.drawable.close),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
                    .size(24.dp)
                    .noRippleClickable {
                        onEvent.invoke(DetailEvent.ClickBackIcon)
                    },
                contentScale = ContentScale.Fit
            )

            Image(
                painter = painterResource(id = if(isLike) ResourceR.drawable.like_on_icon else ResourceR.drawable.like_off_icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 16.dp, top = 16.dp)
                    .size(24.dp)
                    .noRippleClickable {
                        onEvent.invoke(DetailEvent.ClickLikeIcon(isLike = !isLike))
                    },
                contentScale = ContentScale.Fit
            )
        }

        when (uiState.detailUiState) {
            is DetailUiState.Loading -> {
                LoadingAnimation()
            }
            is DetailUiState.Result -> {
                DetailContent(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    pokemon = uiState.detailUiState.pokemon,
                    onEvent = onEvent
                )
            }
            is DetailUiState.Empty -> {}
        }
    }
}