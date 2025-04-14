package com.example.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.home.common.HomeEvent

@Composable
fun HomeErrorScreen(
    onEvent: (HomeEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(
            onClick = { onEvent(HomeEvent.ClickReLoadBtn) },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = "다시 로드",
                modifier = Modifier,
                style = LocalTypography.current.headline2,
                color = LocalColors.current.white,
                maxLines = 1,
                textAlign = TextAlign.Center
            )
        }
    }
}
