package com.example.designsystem.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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