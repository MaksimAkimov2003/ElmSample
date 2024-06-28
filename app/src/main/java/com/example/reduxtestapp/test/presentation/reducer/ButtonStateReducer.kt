package com.example.reduxtestapp.test.presentation.reducer

import com.example.reduxtestapp.test.presentation.effect.MviExampleEffect
import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.state.MviExampleState

class ButtonStateReducer : Reducer<MviExampleState, MviExampleIntent, MviExampleEffect> {

    override fun reduce(state: MviExampleState, intent: MviExampleIntent): ReducerResult<MviExampleState, MviExampleEffect> =
        when (intent) {
            is MviExampleIntent.CounterValueUpdated ->
                ReducerResult(
                    state = state.copy(buttonsState = MviExampleState.ButtonsState.IDLE),
                    effects = emptyList()
                )

            MviExampleIntent.Decrement,
            MviExampleIntent.Increment ->
                ReducerResult(
                    state = state.copy(buttonsState = MviExampleState.ButtonsState.LOADING),
                    effects = emptyList()
                )

            else -> ReducerResult(
                state = state,
                effects = emptyList()
            )
        }

}