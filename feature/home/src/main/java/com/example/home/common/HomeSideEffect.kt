package com.example.home.common

import com.example.base.base.BaseSideEffect
import com.example.model.ui.Pokemon
import com.example.model.ui.PokemonList
import kotlinx.collections.immutable.ImmutableList

sealed class HomeSideEffect: BaseSideEffect() {
    data class ShowFavoriteBottomSheet(val pokemonListList: ImmutableList<PokemonList>) : HomeSideEffect()
    data class ShowAllTypeBottomSheet(val pokemonListList: ImmutableList<PokemonList>) : HomeSideEffect()
    data object ShowGenerationsBottomSheet : HomeSideEffect()
    data object HideGenerationsBottomSheet : HomeSideEffect()
    data object ShowSearchBottomSheet: HomeSideEffect()
    data object CloseBottomSheet: HomeSideEffect()
    data class StartDetailActivity(val pokemon: Pokemon) : HomeSideEffect()
    data object ShowLoadingAnimation : BaseSideEffect()
    data object HideLoadingAnimation : BaseSideEffect()
}