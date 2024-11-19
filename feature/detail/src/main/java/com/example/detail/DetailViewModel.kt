package com.example.detail

import com.example.detail.common.DetailEvent
import com.example.detail.common.DetailSideEffect
import com.example.detail.common.DetailState
import com.example.detail.common.DetailUiState
import com.example.domain.usecase.GetPokemonDetailInfoUseCase
import com.example.domain.usecase.GetPokemonListUseCase
import com.example.log.DebugLog
import com.example.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPokemonDetailInfoUseCase: GetPokemonDetailInfoUseCase
) : BaseViewModel<DetailEvent, DetailState, DetailSideEffect>() {

    override fun createInitialState(): DetailState = DetailState(detailUiState = DetailUiState.Init)
    override fun handleEvent(event: DetailEvent) {
        when (event) {
            DetailEvent.ClickBackIcon -> { }
            is DetailEvent.ClickLikeIcon -> { }
            is DetailEvent.SelectTab -> { }
        }
    }

    fun getPokemonDetailInfo(id: Int){
        DebugLog("vm - getPokemonDetailInfo [${id}]")
        getPokemonDetailInfoUseCase(
            id = id,
            onError = { message ->
                DebugLog("onError - ${message.toString()}")
                setEffect { DetailSideEffect.ShowToast(message = message) }
            }
        )
    }
}