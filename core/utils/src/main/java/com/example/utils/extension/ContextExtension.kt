package com.example.utils.extension

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.content.ContextCompat
import coil.request.ImageRequest
import com.example.resource.R as ResourceR

/**
 * width : dp
 * height : dp
 */
fun Context.setImageUrl(data: String, width: Int, height: Int, usePlaceholder: Boolean = true): ImageRequest{
    val drawable = ContextCompat.getDrawable(this@setImageUrl, ResourceR.drawable.placeholder)
    val paint = Paint().apply { color = Color(0xFFF5F7FA).toArgb()  }
    val placeholder = makeCenteredPlaceholderDrawable(
        width = width.dpToPixel(),
        height = height.dpToPixel(),
        paint = paint,
        placeholder = drawable
    )
    return ImageRequest.Builder(this@setImageUrl)
        .data(data)
        .size(width.dpToPixel(), height.dpToPixel())
        .apply {
            if (usePlaceholder) {
                placeholder(placeholder)
                error(placeholder)
            }
        }
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

            // placeholder 이미지의 비율을 3:1로 축소
            val placeholderHeight = viewHeight / 3
            val placeholderWidth =
                (placeholder.intrinsicWidth * placeholderHeight) / placeholder.intrinsicHeight

            // 중앙 정렬을 위한 좌표 계산
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

private var toast: Toast? = null

fun Context.showToast(message: String?, duration: Int = Toast.LENGTH_SHORT) {
    if (!message.isNullOrEmpty()) {
        if (toast == null) {
            toast = Toast.makeText(applicationContext, message, duration)
        } else {
            toast?.cancel()
            toast = Toast.makeText(applicationContext, message, duration)
            toast?.setText(message)
        }
        toast?.show()
    }
}
