package com.example.home

import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetPokemonInfoUseCase
import com.example.home.common.MainEvent
import com.example.home.common.HomeSideEffect
import com.example.home.common.HomeState
import com.example.home.common.HomeUiState
import com.example.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonInfoUseCase: GetPokemonInfoUseCase
) : BaseViewModel<MainEvent, HomeState, HomeSideEffect>() {

    override fun createInitialState(): HomeState = HomeState(homeUiState = HomeUiState.Empty)
    override fun handleEvent(event: MainEvent) {
        when (event) {
            is MainEvent.ClickCircleMenuBtn -> { }
            is MainEvent.ClickSearchBtn -> { }
            is MainEvent.ClickPokemonCard -> {
                setEffect { HomeSideEffect.StartDetailActivity(pokemonInfo = event.pokemonInfo) }
            }
        }
    }

    private fun getInfoDataByServer(limit: Int?, offset: Int?) {
        viewModelScope.launch {
            getPokemonInfoUseCase.getInfo(
                limit = limit,
                offset = offset
            ).collectLatest { result ->
                setState {
                    if (result.isNotEmpty()) HomeState(homeUiState = HomeUiState.Result(pokemonList = result.toImmutableList()))
                    else HomeState(homeUiState = HomeUiState.Error)
                }
            }
        }
    }
}