package com.example.detail.common

import com.example.mvi.Event

sealed class DetailEvent: Event {
    data object ClickBackIcon : DetailEvent()
    data class ClickLikeIcon(val isLike: Boolean) : DetailEvent()
    data class SelectTab(val tabType: TabType) : DetailEvent()
}