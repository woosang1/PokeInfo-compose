package com.example.utils.extension

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput

inline fun Modifier.noRippleClickable(crossinline onClick: ()->Unit): Modifier = composed {
    then(
        clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() })
        {
            onClick()
        }
    )
}

inline fun Modifier.noRippleSingleClickable(
    delayMillis: Long = 1000L, // 기본 클릭 지연 시간 (1초)
    crossinline onClick: () -> Unit
): Modifier = composed {
    var lastClickTime by remember { mutableLongStateOf(0L) }

    then(
        clickable(
            indication = null, // 리플 효과 없음
            interactionSource = remember { MutableInteractionSource() }
        ) {
            val currentTime = System.currentTimeMillis()
            // 클릭 시간 체크
            if (currentTime - lastClickTime >= delayMillis) {
                lastClickTime = currentTime
                onClick()
            }
        }
    )
}

@SuppressLint("ModifierFactoryUnreferencedReceiver", "ReturnFromAwaitPointerEventScope")
fun Modifier.ignoreClickEvent(): Modifier = pointerInput(Unit) {
    awaitPointerEventScope {
        while (true) {
            awaitPointerEvent(PointerEventPass.Initial)
        }
    }
}