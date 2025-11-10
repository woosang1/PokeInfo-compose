package com.example.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PKImage(
    data: Any?,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
    alignment: Alignment = Alignment.Center,
    clipShape: Shape? = null,
    placeholder: Painter? = null,
    error: Painter? = placeholder,
    fallback: Painter? = placeholder,
    requestBuilder: ImageRequest.Builder.() -> ImageRequest.Builder = { crossfade(true) },
) {
    val context = LocalContext.current
    val request = remember(data) {
        requestBuilder(
            ImageRequest.Builder(context)
                .data(data)
        ).build()
    }

    val clippedModifier = clipShape?.let { modifier.clip(it) } ?: modifier

    AsyncImage(
        model = request,
        modifier = clippedModifier,
        contentDescription = contentDescription,
        contentScale = contentScale,
        alignment = alignment,
        placeholder = placeholder,
        error = error,
        fallback = fallback,
    )
}

