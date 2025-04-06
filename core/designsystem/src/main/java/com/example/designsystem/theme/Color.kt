package com.example.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color


@Immutable
data class ColorSystem(
    val black: Color,
    val purple80: Color,
    val white: Color,
    val lightBlue: Color,
    val softGreen: Color,
    val warmYellow: Color,
    val blue: Color,
    val darkBlue: Color,
    val green: Color,
    val darkGreen: Color,
    val lightGray: Color,
    val gray: Color,
    val darkGray: Color,
    val red: Color,
    val yellow: Color,
    val pink: Color,
    val orange: Color,
    val lightGreen: Color,
    val beige: Color,
    val violet: Color,
    val deepBlue: Color,
    val brown: Color,
    val silver: Color
)

val lightColors = ColorSystem(
    black = Color(0xFF1a1c20),
    purple80 = Color(0xFFD0BCFF),
    white = Color(0xFFFFFFFF),
    lightBlue = Color(0xFFADD8E6),
    softGreen = Color(0xFFB9E4C9),
    warmYellow = Color(0xFFFFF9C4),
    blue = Color(0xFF396EFF),
    darkBlue = Color(0xFF274B91),
    green = Color(0xFF1AC595),
    darkGreen = Color(0xFF107D62),
    lightGray = Color(0xFFF5F7FA),
    gray = Color(0xFFAFC2DB),
    darkGray = Color(0xFF869AB7),
    red = Color(0xFFD32F2F),
    yellow = Color(0xFFFFC107),
    orange = Color(0xFFFF9800),
    lightGreen = Color(0xFF8BC34A),
    beige = Color(0xFFF5F5DC),
    pink = Color(0xFFFFC0CB),
    violet = Color(0xFF7E57C2),
    deepBlue = Color(0xFF3F51B5),
    brown = Color(0xFFA0522D),
    silver = Color(0xFFC0C0C0)
)