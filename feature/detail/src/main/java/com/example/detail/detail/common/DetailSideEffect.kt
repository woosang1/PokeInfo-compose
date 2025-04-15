package com.example.detail.detail.common

import com.example.base.mvi.SideEffect

sealed class DetailSideEffect: SideEffect {
    data object BackPage : DetailSideEffect()
    data class SetLikeIcon(val isLike: Boolean) : DetailSideEffect()
    data class MoveTab(val tabType: TabType) : DetailSideEffect()
    data class ShowToast(val message: String) : DetailSideEffect()
    data class HandleNetworkUI(val throwable: Throwable) : DetailSideEffect()
}