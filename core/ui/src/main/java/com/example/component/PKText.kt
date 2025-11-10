package com.example.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography

@Composable
fun PKText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTypography.current.body1,
    color: Color = LocalColors.current.white,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Ellipsis,
) {
    Text(
        text = text,
        modifier = modifier,
        style = style,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
    )
}

