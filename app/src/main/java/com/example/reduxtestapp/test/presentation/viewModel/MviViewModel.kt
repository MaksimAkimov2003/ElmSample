package com.example.reduxtestapp.test.presentation.viewModel

import com.example.reduxtestapp.test.presentation.effect.MviEffect
import com.example.reduxtestapp.test.presentation.intent.MviIntent
import com.example.reduxtestapp.test.presentation.state.MviState
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface MviViewModel<State : MviState, Intent : MviIntent, Effect: MviEffect> {

    val state: StateFlow<State>

    val effect: SharedFlow<Effect>

    fun dispatch(intent: Intent)
}