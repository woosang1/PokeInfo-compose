package com.example.detail.detail.common

import com.example.base.mvi.Event
import com.example.navigation.DetailTabRoute

sealed class DetailEvent: Event {
    data object ClickBackIcon : DetailEvent()
    data object PressBackActionWithFirstTab : DetailEvent()
    data class ClickLikeIcon(val isLike: Boolean) : DetailEvent()
    data class SelectTab(val detailTabRoute: DetailTabRoute) : DetailEvent()
}