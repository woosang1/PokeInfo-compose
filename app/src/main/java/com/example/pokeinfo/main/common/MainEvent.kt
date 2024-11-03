package com.example.pokeinfo.main.common

import com.example.domain.model.PokemonInfo

sealed class MainEvent {
    data class ClickCircleMenuBtn(val menuType : MenuType) : MainEvent()
    data object ClickSearchBtn : MainEvent()
    data class ClickPokemonCard(val pokemonInfo: PokemonInfo) : MainEvent()
}

enum class MenuType(val description: String){
    Favorite("찜"),
    ALL_TYPE("모든 타입"),
    GENERATION("모든 세대"),
}