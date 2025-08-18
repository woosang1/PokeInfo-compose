package com.example.home.common

import com.example.base.mvi.SideEffect
import com.example.model.ui.Pokemon
import com.example.model.ui.PokemonList
import com.example.utils.UiError
import kotlinx.collections.immutable.ImmutableList

sealed class HomeSideEffect: SideEffect {
    data class ShowFavoriteBottomSheet(val pokemonListList: ImmutableList<PokemonList>) : HomeSideEffect()
    data object ShowGenerationsBottomSheet : HomeSideEffect()
    data object ShowSearchBottomSheet: HomeSideEffect()
    data class StartDetailActivity(val pokemon: Pokemon) : HomeSideEffect()
    data class ShowToast(val message: String): HomeSideEffect()
    data class HandleNetworkUI(val uiError: UiError) : HomeSideEffect()
}