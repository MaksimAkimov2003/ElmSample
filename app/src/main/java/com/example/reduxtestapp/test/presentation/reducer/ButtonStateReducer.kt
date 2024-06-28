package com.example.reduxtestapp.test.presentation.reducer

import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.state.MviExampleState

class ButtonStateReducer : Reducer<MviExampleState, MviExampleIntent> {

    override fun reduce(
        state: MviExampleState,
        intent: MviExampleIntent
    ) =
        when (intent) {
            is MviExampleIntent.CounterValueUpdated ->
                state.copy(buttonsState = MviExampleState.ButtonsState.IDLE)

            MviExampleIntent.Decrement,
            MviExampleIntent.Increment ->
                state.copy(buttonsState = MviExampleState.ButtonsState.LOADING)

            else -> state

        }

}