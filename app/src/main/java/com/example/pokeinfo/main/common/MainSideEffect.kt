package com.example.pokeinfo.main.common

import com.example.domain.model.PokemonInfo
import kotlinx.collections.immutable.ImmutableList

sealed class MainSideEffect {
    data class ShowFavoriteBottomSheet(val pokemonInfoList: ImmutableList<PokemonInfo>) : MainSideEffect()
    data class ShowAllTypeBottomSheet(val pokemonInfoList: ImmutableList<PokemonInfo>) : MainSideEffect()
    data class ShowGenerationsBottomSheet(val pokemonInfoList: ImmutableList<PokemonInfo>) : MainSideEffect()
    data object ShowSearchBottomSheet: MainSideEffect()
    data object CloseBottomSheet: MainSideEffect()
    data class ShowToast(val message: String) : MainSideEffect()
    data class StartDetailActivity(val pokemonInfo: PokemonInfo) : MainSideEffect()
}