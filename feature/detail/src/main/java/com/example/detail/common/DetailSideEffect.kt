package com.example.detail.common

import com.example.domain.model.PokemonList
import com.example.ui.SideEffect
import kotlinx.collections.immutable.ImmutableList

sealed class DetailSideEffect: SideEffect {
    data object StartHomePage : DetailSideEffect()
    data class SetLikeIcon(val isLike: Boolean) : DetailSideEffect()
    data class MoveTab(val tabType: TabType) : DetailSideEffect()
    data class ShowToast(val message: String) : DetailSideEffect()
}