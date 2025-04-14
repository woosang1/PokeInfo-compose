package com.example.home.common

import com.example.base.mvi.Event
import com.example.model.ui.Pokemon

sealed interface HomeEvent: Event {
    data class ClickFloatingBtn(val menuType : MenuType) : HomeEvent
    data class SelectGeneration(val generation: Int) : HomeEvent
    data class ClickPokemonCard(val pokemon: Pokemon) : HomeEvent
    data class OnPagingError(val message: String) : HomeEvent
}

