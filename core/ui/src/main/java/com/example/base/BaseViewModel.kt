package com.example.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.utils.errorHandler.UiError
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<Event : com.example.mvi.Event, State : com.example.mvi.State, Effect : BaseSideEffect> : ViewModel() {

    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State

    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    val event = _event.asSharedFlow()

    private val _effect: Channel<BaseSideEffect> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        subscribeEvents()
    }

    private fun subscribeEvents() {
        viewModelScope.launch {
            event.collect {
                handleEvent(it)
            }
        }
    }

    abstract fun handleEvent(event: Event)

    fun setEvent(event: Event) {
        viewModelScope.launch { _event.emit(event) }
    }

    protected fun setState(reduce: State.() -> State) {
        val newState = state.value.reduce()
        _state.value = newState
    }

    fun setEffect(effect: BaseSideEffect) {
        viewModelScope.launch { _effect.send(effect) }
    }

    fun handlerError(error: UiError){
        when(error){
            is UiError.AuthError -> { setEffect(BaseSideEffect.ShowToast(message = error.message)) }
            is UiError.PermissionError -> { setEffect(BaseSideEffect.ShowToast(message = error.message)) }
            is UiError.NetworkError -> { setEffect(BaseSideEffect.ShowToast(message = error.message)) }
            is UiError.ServerError -> { setEffect(BaseSideEffect.ShowToast(message = error.message)) }
            is UiError.UnknownError -> { setEffect(BaseSideEffect.ShowToast(message = error.message)) }
        }
    }

}