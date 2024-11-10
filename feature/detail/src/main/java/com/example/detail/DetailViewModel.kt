package com.example.detail

import com.example.detail.common.DetailEvent
import com.example.detail.common.DetailSideEffect
import com.example.detail.common.DetailState
import com.example.detail.common.DetailUiState
import com.example.domain.usecase.GetPokemonInfoUseCase
import com.example.domain.usecase.GetPokemonListUseCase
import com.example.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPokemonInfoUseCase: GetPokemonInfoUseCase
) : BaseViewModel<DetailEvent, DetailState, DetailSideEffect>() {

    override fun createInitialState(): DetailState = DetailState(detailUiState = DetailUiState.Init)
    override fun handleEvent(event: DetailEvent) {
        when (event) {
            DetailEvent.ClickBackIcon -> { }
            is DetailEvent.ClickLikeIcon -> { }
            is DetailEvent.SelectTab -> { }
        }
    }

    suspend fun getPokemonInfo(id: Int){
        getPokemonInfoUseCase(
            id = id,
            onError = { message -> }
        )
    }
}