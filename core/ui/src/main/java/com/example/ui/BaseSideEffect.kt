package com.example.ui

open class BaseSideEffect: SideEffect {
    data class ShowToast(val message: String) : BaseSideEffect()
}
