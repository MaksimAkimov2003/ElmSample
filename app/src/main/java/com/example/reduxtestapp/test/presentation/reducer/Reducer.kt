package com.example.reduxtestapp.test.presentation.reducer

import com.example.reduxtestapp.test.presentation.intent.MviIntent
import com.example.reduxtestapp.test.presentation.state.MviState

interface Reducer<State : MviState, Intent : MviIntent> {

    fun reduce(state: State, intent: Intent): State
}