package com.example.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import com.example.detail.common.DetailEvent
import com.example.detail.common.DetailSideEffect
import com.example.detail.common.DetailState
import com.example.detail.common.DetailUiState
import com.example.ui.R
import com.example.utils.noRippleClickable

@Composable
fun DetailScreen(
    uiState: DetailState,
    onNavigateHome: () -> Unit,
    onInit: () -> Unit,
    onEvent: (DetailEvent) -> Unit,
    onSideEffect: (DetailSideEffect) -> Unit,
) {
    LaunchedEffect(true) { onInit.invoke() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.purple80)
    ) {
        Image(
            painter = painterResource(id = R.drawable.close),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 16.dp)
                .size(36.dp)
                .noRippleClickable {
                    onNavigateHome.invoke()
                },
            contentScale = ContentScale.Fit
        )

        when(uiState.detailUiState){
            DetailUiState.Loading -> {}
            DetailUiState.Result -> {}
            DetailUiState.Empty -> {}
        }
    }
}