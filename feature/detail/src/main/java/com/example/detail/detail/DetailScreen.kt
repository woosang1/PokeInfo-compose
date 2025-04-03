package com.example.detail.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import com.example.detail.detail.common.DetailEvent
import com.example.detail.detail.common.DetailSideEffect
import com.example.detail.detail.common.DetailState
import com.example.detail.detail.common.DetailUiState
import com.example.extension.noRippleClickable
import com.example.log.DebugLog
import com.example.ui.R

@Composable
fun DetailScreen(
    uiState: DetailState,
    onBackEvent: () -> Unit,
    onInit: () -> Unit,
    onEvent: (DetailEvent) -> Unit,
    onSideEffect: (DetailSideEffect) -> Unit,
) {
    LaunchedEffect(true) { onInit.invoke() }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.purple80),
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.close),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .size(36.dp)
                .noRippleClickable {
                    DebugLog("뒤로가긱 클릭")
                    onBackEvent.invoke()
                },
            contentScale = ContentScale.Fit
        )

        when (uiState.detailUiState) {
            is DetailUiState.Loading -> {}
            is DetailUiState.Result -> {
                DetailContent(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    pokemon = uiState.detailUiState.pokemon,
                    onBackEvent = onBackEvent
                )
            }
            is DetailUiState.Empty -> {}
        }
    }
}