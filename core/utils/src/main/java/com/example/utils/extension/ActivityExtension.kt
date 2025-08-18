package com.example.utils.extension

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowInsetsController
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

// 상태바 보이기.
fun Activity.showStateBar(isLightMode: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) { // Android 15+
        WindowCompat.setDecorFitsSystemWindows(window, true)
        window.decorView.setOnApplyWindowInsetsListener { view, insets ->
            view.setBackgroundColor(Color.WHITE)
            // 상태바.
            val statusBarInsets = insets.getInsets(WindowInsetsCompat.Type.statusBars())
            val navBarInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars())
            val imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime())

            // IME가 올라오면 그걸 우선, 아니면 네비게이션 바를 바텀에 적용
            val bottomPadding = if (imeInsets.bottom > 0) imeInsets.bottom else navBarInsets.bottom

            view.setPadding(0, statusBarInsets.top, 0, bottomPadding)

            // 상태바/네비게이션 바 밝기 설정
            window.insetsController?.setSystemBarsAppearance(
                if (isLightMode) WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS or WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
                else 0, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS or WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
            )

            insets
        }
    } else {
        // For Android 14 and below
        window.statusBarColor = Color.WHITE
        val flags = window.decorView.systemUiVisibility
        if (isLightMode) window.decorView.systemUiVisibility = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR and View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN.inv()
        else window.decorView.systemUiVisibility = flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv() and View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN.inv()
    }
}