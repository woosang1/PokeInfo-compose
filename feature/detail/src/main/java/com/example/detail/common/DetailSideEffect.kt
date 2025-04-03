package com.example.detail.common

import com.example.base.base.BaseSideEffect

sealed class DetailSideEffect: BaseSideEffect() {
    data object StartHomePage : DetailSideEffect()
    data class SetLikeIcon(val isLike: Boolean) : DetailSideEffect()
    data class MoveTab(val tabType: TabType) : DetailSideEffect()
}