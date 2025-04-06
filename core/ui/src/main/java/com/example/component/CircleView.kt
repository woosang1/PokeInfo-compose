package com.example.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.component.common.getPokemonColorType
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography

@Composable
fun CircleView(
    modifier: Modifier = Modifier,
    title: String,
) {
    val backgroundColor = title.getPokemonColorType().copy(alpha = 1f)

    Box(
        modifier = modifier
            .wrapContentSize()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(50)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = title,
            style = LocalTypography.current.subTitle,
            color = LocalColors.current.white,
            maxLines = 1
        )
    }
}