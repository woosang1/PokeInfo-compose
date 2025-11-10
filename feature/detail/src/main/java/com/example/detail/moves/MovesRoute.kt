package com.example.detail.moves

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.component.PKText
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography

@Composable
fun MovesRoute(
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.white)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PKText(
                text = "영상 기능",
                style = LocalTypography.current.headline2,
                color = LocalColors.current.black,
                textAlign = TextAlign.Center
            )
            PKText(
                text = "곧 추가될 예정입니다",
                style = LocalTypography.current.body1,
                color = LocalColors.current.darkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}