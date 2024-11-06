package com.example.main

import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetPokemonInfoUseCase
import com.example.main.common.MainEvent
import com.example.main.common.MainSideEffect
import com.example.main.common.MainState
import com.example.main.common.MainUiState
import com.example.ui.BaseViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getPokemonInfoUseCase: GetPokemonInfoUseCase
) : BaseViewModel<MainEvent, MainState, MainSideEffect>() {
    override fun createInitialState(): MainState = MainState(mainUiState = MainUiState.Empty)
    override fun handleEvent(event: MainEvent) {
        when (event) {
            is MainEvent.ClickCircleMenuBtn -> { }
            is MainEvent.ClickSearchBtn -> { }
            is MainEvent.ClickPokemonCard -> { }
        }
    }

    private fun getInfoDataByServer(limit: Int?, offset: Int?) {
        viewModelScope.launch {
            getPokemonInfoUseCase.getInfo(
                limit = limit,
                offset = offset
            ).collectLatest { result ->
                if (result == null) setState { MainState(mainUiState = MainUiState.Error) }
                else {
                    setState {
                        if (result.isNotEmpty()) MainState(mainUiState = MainUiState.Result(pokemonList = result.toImmutableList()))
                        else MainState(mainUiState = MainUiState.Error)
                    }
                }
            }
        }
    }
}