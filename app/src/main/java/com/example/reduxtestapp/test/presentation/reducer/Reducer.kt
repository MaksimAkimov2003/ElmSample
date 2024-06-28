package com.example.reduxtestapp.test.presentation.reducer

import com.example.reduxtestapp.test.presentation.effect.MviEffect
import com.example.reduxtestapp.test.presentation.state.MviState
import com.example.reduxtestapp.test.presentation.intent.MviIntent

interface Reducer<State : MviState, Intent : MviIntent, Effect: MviEffect> {

    fun reduce(state: State, intent: Intent): ReducerResult<State, Effect>
}