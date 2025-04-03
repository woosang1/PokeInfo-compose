package com.example.detail.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.model.ui.AboutModel

@Composable
fun AboutRoute(
    model: AboutModel?
) {
    AboutScreen(
        model = model
    )
}

@Composable
fun AboutScreen(
    model: AboutModel?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.white)
            .padding(horizontal = 12.dp, vertical = 20.dp)
    ) {
        if (model != null){
            Text(
                text = model.description,
                modifier = Modifier
                    .weight(1f),
                style = LocalTypography.current.headline3,
                color = LocalColors.current.black,
                maxLines = 1,
                textAlign = TextAlign.Start
            )
        }
    }
}