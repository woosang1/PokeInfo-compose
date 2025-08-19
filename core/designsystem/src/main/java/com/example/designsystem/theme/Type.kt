package com.example.designsystem.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import com.example.utils.extension.textDp
import com.example.designsystem.R

data class TypographySystem(
    private val colors: ColorSystem,
    private val density: Density? = null,
    val baseTextStyle: TextStyle = TextStyle(
        color = colors.white,
    ),

    val headline1: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.textDp(density),
        lineHeight = 40.textDp(density)
    ),

    val headline2: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.textDp(density),
        lineHeight = 34.textDp(density)
    ),

    val headline3: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.textDp(density),
        lineHeight = 20.textDp(density)
    ),

    val body1: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.Normal,
        fontSize = 16.textDp(density),
        lineHeight = 28.textDp(density)
    ),

    val form3B: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.Normal,
        fontSize = 12.textDp(density),
        lineHeight = 16.textDp(density)
    ),

    val form3: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.Normal,
        fontSize = 12.textDp(density),
        lineHeight = 16.textDp(density)
    ),

    val subTitle: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.Normal,
        fontSize = 14.textDp(density),
        lineHeight = 24.textDp(density)
    ),

    val caption1: TextStyle = baseTextStyle.copy(
        fontFamily = nanumSquare,
        fontWeight = FontWeight.Normal,
        fontSize = 12.textDp(density),
        lineHeight = 20.textDp(density)
    ),

    )

val nanumSquare = FontFamily(
    Font(R.font.nanumsquare_neo_heavy, FontWeight.Black, FontStyle.Normal),
    Font(R.font.nanumsquare_otfb, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.nanumsquare_otfeb, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.nanumsquare_otfl, FontWeight.Light, FontStyle.Normal),
    Font(R.font.nanumsquare_otfr, FontWeight.Normal, FontStyle.Normal),
)


