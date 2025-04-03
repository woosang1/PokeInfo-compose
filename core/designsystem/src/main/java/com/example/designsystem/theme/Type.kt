package com.example.designsystem.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import com.example.pokeinfo.R
import com.example.extension.textDp

data class TypographySystem(
    private val colors: ColorSystem,
    private val density: Density? = null,
    val baseTextStyle: TextStyle = TextStyle(
        color = colors.black,
    ),
    val title1: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.Bold,
        fontSize = 16.textDp(density),
        lineHeight = 18.textDp(density)
    ),
    val title2: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.textDp(density),
        lineHeight = 18.textDp(density)
    ),
    val title3: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.Normal,
        fontSize = 16.textDp(density),
        lineHeight = 18.textDp(density)
    ),
    val title4: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.Normal,
        fontSize = 14.textDp(density),
        lineHeight = 18.textDp(density)
    ),
    val title5: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.textDp(density),
        lineHeight = 16.textDp(density)
    ),
    val title6: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.Bold,
        fontSize = 14.textDp(density),
        lineHeight = 16.textDp(density)
    )
)

val nanumSquare = FontFamily(
    Font(R.font.nanumsquare_neo_heavy, FontWeight.Black, FontStyle.Normal),
    Font(R.font.nanumsquare_otfb, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.nanumsquare_otfeb, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.nanumsquare_otfl, FontWeight.Light, FontStyle.Normal),
    Font(R.font.nanumsquare_otfr, FontWeight.Normal, FontStyle.Normal),
)


