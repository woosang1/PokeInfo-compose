package com.example.home.common

import com.example.domain.model.Pokemon
import com.example.ui.Event

sealed class MainEvent: Event {
    data object ClickFloatingBtn : MainEvent()
    data class ClickSideFloatingBtn(val menuType : MenuType) : MainEvent()
    data object ClickSearchBtn : MainEvent()
    data class ClickPokemonCard(val pokemon: com.example.domain.model.Pokemon) : MainEvent()
}

