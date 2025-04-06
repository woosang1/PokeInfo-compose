package com.example.home.common

import com.example.base.base.BaseSideEffect
import kotlinx.collections.immutable.ImmutableList

sealed class HomeSideEffect: BaseSideEffect() {
    data class ShowFavoriteBottomSheet(val pokemonListList: ImmutableList<com.example.model.ui.PokemonList>) : HomeSideEffect()
    data class ShowAllTypeBottomSheet(val pokemonListList: ImmutableList<com.example.model.ui.PokemonList>) : HomeSideEffect()
    data object ShowGenerationsBottomSheet : HomeSideEffect()
    data object HideGenerationsBottomSheet : HomeSideEffect()
    data object ShowSearchBottomSheet: HomeSideEffect()
    data object CloseBottomSheet: HomeSideEffect()
    data class StartDetailActivity(val pokemon: com.example.model.ui.Pokemon) : HomeSideEffect()
}