package com.example.detail.detail

import androidx.lifecycle.viewModelScope
import com.example.detail.detail.common.DetailEvent
import com.example.detail.detail.common.DetailSideEffect
import com.example.detail.detail.common.DetailState
import com.example.detail.detail.common.DetailUiState
import com.example.domain.usecase.GetPokemonDetailInfoUseCase
import com.example.base.base.BaseViewModel
import com.example.log.DebugLog
import com.example.toUiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPokemonDetailInfoUseCase: GetPokemonDetailInfoUseCase
) : BaseViewModel<DetailEvent, DetailState, DetailSideEffect>() {

    override fun createInitialState(): DetailState = DetailState(detailUiState = DetailUiState.Loading)
    override fun handleEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.ClickBackIcon -> { }
            is DetailEvent.ClickLikeIcon -> { }
            is DetailEvent.SelectTab -> { }
        }
    }

    fun getPokemonDetailInfo(id: Int){
        viewModelScope.launch {
            flow { emit(getPokemonDetailInfoUseCase(id)) }
                .catch { throwable ->
                    DebugLog("error : ${throwable.message}")
                    setState { copy(detailUiState = DetailUiState.Empty) }
                    handlerError(throwable.toUiError())
                }
                .collectLatest { pokemon ->
                    setState { copy(detailUiState = DetailUiState.Result(pokemon = pokemon)) }
                }
        }
    }
}