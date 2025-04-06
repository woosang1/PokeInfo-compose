package com.example.home.common

import com.example.model.ui.Pokemon
import com.example.base.mvi.Event

sealed interface HomeEvent: Event {
    data object ClickFloatingBtn : HomeEvent
    data class ClickSideFloatingBtn(val menuType : MenuType) : HomeEvent
    data object ClickSearchBtn : HomeEvent
    data class SelectGeneration(val generation: Int) : HomeEvent
    data class ClickPokemonCard(val pokemon: Pokemon) : HomeEvent
}

