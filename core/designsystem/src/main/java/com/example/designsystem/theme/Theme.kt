package com.example.designsystem.theme

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity


val LocalColors = staticCompositionLocalOf { lightColors }
val LocalTypography = staticCompositionLocalOf { TypographySystem(lightColors) }


@Composable
fun PokeInfoTheme(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val typographySystem = TypographySystem(lightColors, LocalDensity.current)

    CompositionLocalProvider(
        LocalColors provides lightColors,
        LocalTypography provides typographySystem
    ) {
        Surface(
            color = LocalColors.current.white,
            modifier = modifier
        ) {
            content()
        }
    }
}