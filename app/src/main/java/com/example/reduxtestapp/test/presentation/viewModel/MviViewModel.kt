package com.example.reduxtestapp.test.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.reduxtestapp.test.presentation.effect.MviEffect
import com.example.reduxtestapp.test.presentation.intent.MviIntent
import com.example.reduxtestapp.test.presentation.state.MviState
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

abstract class MviViewModel<State : MviState, Intent : MviIntent, Effect: MviEffect>: ViewModel() {

    abstract val state: StateFlow<State>

    abstract val effect: SharedFlow<Effect>

    abstract fun dispatch(intent: Intent)
}