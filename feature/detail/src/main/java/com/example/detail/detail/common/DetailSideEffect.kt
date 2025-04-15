package com.example.detail.detail.common

import com.example.base.mvi.SideEffect
import com.example.utils.UiError

sealed class DetailSideEffect: SideEffect {
    data object NavigateBack : DetailSideEffect()
    data class SetLikeIcon(val isLike: Boolean) : DetailSideEffect()
    data class MoveTab(val tabType: TabType) : DetailSideEffect()
    data class ShowToast(val message: String) : DetailSideEffect()
    data class HandleNetworkUI(val uiError: UiError) : DetailSideEffect()
}