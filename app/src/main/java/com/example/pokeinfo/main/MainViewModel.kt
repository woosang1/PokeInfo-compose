package com.example.pokeinfo.main

import com.example.pokeinfo.main.common.MainEvent
import com.example.pokeinfo.main.common.MainSideEffect
import com.example.pokeinfo.main.common.MainState
import com.example.pokeinfo.main.common.MainUiState
import com.example.ui.BaseViewModel

class MainViewModel : BaseViewModel<MainEvent, MainState, MainSideEffect>() {
    override fun createInitialState(): MainState = MainState(mainUiState = MainUiState.Empty)
    override fun handleEvent(event: MainEvent) {
        when (event) {
            is MainEvent.ClickCircleMenuBtn -> { }
            is MainEvent.ClickSearchBtn -> { }
            is MainEvent.ClickPokemonCard -> { }
        }
    }
}