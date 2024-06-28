package com.example.reduxtestapp.test.presentation.reducer

import com.example.reduxtestapp.test.presentation.effect.MviExampleEffect
import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.state.MviExampleState

/**
 * Отвечает ТОЛЬКО за кнопку
 */
class ButtonStateReducer : Reducer<MviExampleState, MviExampleIntent, MviExampleEffect> {

    override fun invoke(
        state: MviExampleState,
        intent: MviExampleIntent
    ): ReducerResult<MviExampleState, MviExampleEffect> =
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