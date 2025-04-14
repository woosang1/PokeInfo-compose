package com.example.utils.state

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import kotlinx.coroutines.launch

@Composable
fun rememberFoldableState(context: Context): State<FoldingFeature?> {
    val foldableState = remember { mutableStateOf<FoldingFeature?>(null) }
    val scope = rememberCoroutineScope()
    val windowInfoTracker = WindowInfoTracker.getOrCreate(context)

    DisposableEffect(Unit) {
        val flow = windowInfoTracker.windowLayoutInfo(context as Activity)
        val job = scope.launch {
            flow.collect { layoutInfo ->
                val foldingFeature = layoutInfo.displayFeatures
                    .filterIsInstance<FoldingFeature>()
                    .firstOrNull()
                foldableState.value = foldingFeature
            }
        }

        onDispose {
            job.cancel()
        }
    }

    return foldableState
}

