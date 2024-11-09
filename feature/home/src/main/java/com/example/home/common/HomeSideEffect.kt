package com.example.home.common

import com.example.domain.model.PokemonList
import com.example.ui.SideEffect
import kotlinx.collections.immutable.ImmutableList

sealed class HomeSideEffect: SideEffect {
    data class ShowFavoriteBottomSheet(val pokemonListList: ImmutableList<PokemonList>) : HomeSideEffect()
    data class ShowAllTypeBottomSheet(val pokemonListList: ImmutableList<PokemonList>) : HomeSideEffect()
    data class ShowGenerationsBottomSheet(val pokemonListList: ImmutableList<PokemonList>) : HomeSideEffect()
    data object ShowSearchBottomSheet: HomeSideEffect()
    data object CloseBottomSheet: HomeSideEffect()
    data class ShowToast(val message: String) : HomeSideEffect()
    data class StartDetailActivity(val pokemon: PokemonList.Pokemon) : HomeSideEffect()
}