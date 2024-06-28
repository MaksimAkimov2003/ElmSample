package com.example.reduxtestapp.test.presentation.reducer

import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.state.MviExampleState

class CounterReducer : Reducer<MviExampleState, MviExampleIntent> {

    override fun reduce(state: MviExampleState, intent: MviExampleIntent): MviExampleState {
        return when (intent) {
            is MviExampleIntent.CounterValueUpdated -> state.copy(counter = intent.newValue)
            MviExampleIntent.OpenScreen,
            MviExampleIntent.Decrement,
            MviExampleIntent.Increment -> state
        }
    }
}