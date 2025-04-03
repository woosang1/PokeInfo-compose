package com.example.base.base

import com.example.base.mvi.SideEffect


open class BaseSideEffect: SideEffect {
    data class ShowToast(val message: String) : BaseSideEffect()
}
