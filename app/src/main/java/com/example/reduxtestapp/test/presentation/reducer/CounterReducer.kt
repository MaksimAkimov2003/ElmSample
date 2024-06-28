package com.example.reduxtestapp.test.presentation.reducer

import com.example.reduxtestapp.test.presentation.effect.MviExampleEffect
import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.state.MviExampleState

/**
 * Отвечает ТОЛЬКО за счетчик
 */
class CounterReducer : Reducer<MviExampleState, MviExampleIntent, MviExampleEffect> {

    override fun invoke(
        state: MviExampleState,
        intent: MviExampleIntent
    ): ReducerResult<MviExampleState, MviExampleEffect> =
        when (intent) {
            is MviExampleIntent.CounterValueUpdated -> ReducerResult(
                state = state.copy(counter = intent.newValue),
                effects = emptyList()
            )

            MviExampleIntent.OpenScreen,
            MviExampleIntent.Decrement,
            MviExampleIntent.Increment -> ReducerResult(
                state = state,
                effects = emptyList()
            )
        }
}