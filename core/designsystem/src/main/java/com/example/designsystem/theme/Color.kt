package com.example.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color


@Immutable
data class ColorSystem(
    val black: Color,
    val purple80: Color,
    val white: Color,
)

val lightColors: ColorSystem = ColorSystem(
    black = Color(0xFF1a1c20),
    purple80 = Color(0xFFD0BCFF),
    white = Color(0xFFFFFFFF),
)