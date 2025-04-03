package com.example.detail.detail.common

sealed class DetailEvent: com.example.base.mvi.Event {
    data object ClickBackIcon : DetailEvent()
    data class ClickLikeIcon(val isLike: Boolean) : DetailEvent()
    data class SelectTab(val tabType: TabType) : DetailEvent()
}