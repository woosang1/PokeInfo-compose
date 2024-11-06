package com.example.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import coil.request.ImageRequest

/**
 * width : dp
 * height : dp
 */
fun Context.setImageUrl(data: String, width: Int, height: Int): ImageRequest{
//    val drawable = ContextCompat.getDrawable(this@setImageUrl, R.drawable.icon_nol_gray06)
    val paint = Paint().apply { color = Color(0xFFE1E4E6).toArgb()  }
    val placeholder = makeCenteredPlaceholderDrawable(
        width = width.dpToPixel(),
        height = height.dpToPixel(),
        paint = paint,
//        placeholder = drawable
        placeholder = null
    )
    return ImageRequest.Builder(this@setImageUrl)
        .data(data)
        .placeholder(placeholder)
        .error(placeholder)
        .build()
}

// 디바이스 너비
fun Context.getWidthDisplay(): Int {
    val metrics = resources.displayMetrics
    return metrics.widthPixels
}

// 디바이스 높이
fun Context.getHeightDisplay(): Int {
    val metrics = resources.displayMetrics
    return metrics.heightPixels
}

/**
 * [width] - px
 * [height] - px
 */
private fun makeCenteredPlaceholderDrawable(
    paint: Paint,
    width: Int,
    height: Int,
    placeholder: Drawable?
): Drawable? {
    if (placeholder == null) return null
    val centeredDrawable = object : Drawable() {
        override fun draw(canvas: Canvas) {
            val viewWidth = width
            val viewHeight = height

            // 백그라운드 칠하기
            canvas.drawRect(0f, 0f, viewWidth.toFloat(), viewHeight.toFloat(), paint)

            // imageView : placeholder 세로 비율 (3 : 1)
            val placeholderHeight = viewHeight / 3
            val placeholderWidth =
                (placeholder.intrinsicWidth * placeholderHeight) / placeholder.intrinsicHeight

            val left = (viewWidth - placeholderWidth) / 2
            val top = (viewHeight - placeholderHeight) / 2
            val right = left + placeholderWidth
            val bottom = top + placeholderHeight


            placeholder.setBounds(left, top, right, bottom)
            placeholder.draw(canvas)
        }

        override fun setAlpha(alpha: Int) {
            placeholder.alpha = alpha
        }

        override fun setColorFilter(colorFilter: ColorFilter?) {
            placeholder.colorFilter = colorFilter
        }

        override fun getOpacity(): Int = placeholder.opacity
    }
    return centeredDrawable
}

