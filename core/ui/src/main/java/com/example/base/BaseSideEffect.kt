package com.example.base

import com.example.mvi.SideEffect

open class BaseSideEffect: SideEffect {
    data class ShowToast(val message: String) : BaseSideEffect()
}
