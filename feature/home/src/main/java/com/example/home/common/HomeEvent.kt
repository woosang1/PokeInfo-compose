package com.example.home.common

import com.example.domain.model.PokemonList
import com.example.ui.Event

sealed class MainEvent: Event {
    data class ClickCircleMenuBtn(val menuType : MenuType) : MainEvent()
    data object ClickSearchBtn : MainEvent()
    data class ClickPokemonCard(val pokemon: PokemonList.Pokemon) : MainEvent()
}

