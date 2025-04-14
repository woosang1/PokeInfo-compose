package com.example.utils.extension

import android.content.res.Resources
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun Int.textDp(density: Density?): TextUnit {
    return  if(density == null) this.sp
    else {
        with(density) {
            this@textDp.dp.toSp()
        }
    }
}

/**
 * Px값을 DP로 변환
 */
fun Int.pxToDp(): Int =
    (this / Resources.getSystem().displayMetrics.density).toInt()

/**
 * Dp값을 PX로 변환
 */
fun Int.dpToPixel(): Int =
    (this * Resources.getSystem().displayMetrics.density).toInt()
