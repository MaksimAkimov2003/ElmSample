package com.example.reduxtestapp.test.presentation.reducer

import com.example.reduxtestapp.test.presentation.effect.MviEffect
import com.example.reduxtestapp.test.presentation.effect.MviExampleEffect
import com.example.reduxtestapp.test.presentation.state.MviExampleState
import com.example.reduxtestapp.test.presentation.state.MviState

data class ReducerResult<State: MviState, Effect: MviEffect>(
    val state: State,
    val effects: List<Effect> = emptyList()
)
