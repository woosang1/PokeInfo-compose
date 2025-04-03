package com.example.home.common

import com.example.domain.model.Pokemon
import com.example.ui.Event

sealed interface HomeEvent: Event {
    data object ClickFloatingBtn : HomeEvent
    data class ClickSideFloatingBtn(val menuType : MenuType) : HomeEvent
    data object ClickSearchBtn : HomeEvent
    data class ClickPokemonCard(val pokemon: Pokemon) : HomeEvent
}

