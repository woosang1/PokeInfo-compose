package com.example.main

import com.example.main.common.MainEvent
import com.example.main.common.MainSideEffect
import com.example.main.common.MainState
import com.example.main.common.MainUiState
import com.example.ui.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel<MainEvent, MainState, MainSideEffect>() {
    override fun createInitialState(): MainState = MainState(mainUiState = MainUiState.Empty)
    override fun handleEvent(event: MainEvent) {
        when (event) {
            is MainEvent.ClickCircleMenuBtn -> { }
            is MainEvent.ClickSearchBtn -> { }
            is MainEvent.ClickPokemonCard -> { }
        }
    }
}