package com.example.utils.extension

import androidx.window.layout.FoldingFeature

/**
 * FLAT - 완전 오픈
 * HALF_OPENED - 절반 오픈
 * null - 접음
 */
fun FoldingFeature?.isDualScreen(): Boolean =
    (this@isDualScreen?.state == FoldingFeature.State.FLAT) || (this@isDualScreen?.state == FoldingFeature.State.HALF_OPENED)
