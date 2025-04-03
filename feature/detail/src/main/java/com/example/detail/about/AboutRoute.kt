package com.example.detail.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.designsystem.theme.LocalColors

@Composable
fun AboutRoute(
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
        .background(LocalColors.current.lightBlue))
}