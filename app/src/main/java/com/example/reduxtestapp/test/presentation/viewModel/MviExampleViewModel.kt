package com.example.reduxtestapp.test.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reduxtestapp.test.presentation.effect.MviEffect
import com.example.reduxtestapp.test.presentation.effect.MviExampleEffect
import com.example.reduxtestapp.test.presentation.reducer.Reducer
import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.middleware.Middleware
import com.example.reduxtestapp.test.presentation.state.MviExampleState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MviExampleViewModel(
    private val reducers: Set<Reducer<MviExampleState, MviExampleIntent, MviExampleEffect>>,
    private val middlewares: Set<Middleware<MviExampleState, MviExampleIntent>>,
) : MviViewModel<MviExampleState, MviExampleIntent, MviExampleEffect>() {

    private val _state = MutableStateFlow(MviExampleState())
    override val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<MviExampleEffect>()
    override val effect: SharedFlow<MviExampleEffect>
        get() = _effect.shareIn(viewModelScope, SharingStarted.WhileSubscribed(5000L))

    override fun dispatch(intent: MviExampleIntent) {
        Log.d("MviExampleViewModel", "dispatch: $intent")

        viewModelScope.launch {
            handleIntentByReducers(intent)
            handleIntentByMiddlewares(intent)
        }
    }

    private suspend fun handleIntentByReducers(intent: MviExampleIntent) {
        reducers.forEach { reducer ->
            val reducerResult = reducer.reduce(_state.value, intent)
            _state.update {
                reducerResult.state
            }
            reducerResult.effects.forEach { effect ->
                _effect.emit(effect)
            }
        }
    }

    private suspend fun handleIntentByMiddlewares(intent: MviExampleIntent) {
        middlewares.forEach { middleware ->
            val intentResult = middleware.handleIntent(_state.value, intent)

            if (intentResult != intent) {
                dispatch(intentResult)
            }
        }

    }
}