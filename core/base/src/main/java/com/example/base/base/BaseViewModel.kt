package com.example.base.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import com.example.base.mvi.SideEffect
import com.example.utils.UiError
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

abstract class BaseViewModel<Event : com.example.base.mvi.Event, State : com.example.base.mvi.State, Effect : SideEffect> : ViewModel() {

    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State

    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow(
        replay = 0,
        extraBufferCapacity = 64,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val event = _event.asSharedFlow()

    private val _effect = Channel<Effect>(capacity = Channel.BUFFERED)
    val effect: Flow<Effect> = _effect.receiveAsFlow()

    // 성능 최적화: 상태 업데이트 동기화를 위한 Mutex
    private val stateMutex = Mutex()

    init {
        event
            .onEach { handleEvent(it) }
            .launchIn(viewModelScope)
    }

    abstract fun handleEvent(event: Event)

    fun setEvent(event: Event) {
        viewModelScope.launch { 
            _event.emit(event) 
        }
    }

    protected fun setState(reduce: State.() -> State) {
        viewModelScope.launch {
            stateMutex.withLock {
                _state.update { current -> current.reduce() }
            }
        }
    }
    fun setEffect(effect: Effect) {
        viewModelScope.launch { _effect.send(effect) }
    }
}