package com.example.reduxtestapp.test.presentation.reducer

import com.example.reduxtestapp.test.presentation.effect.MviExampleEffect
import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.state.MviExampleState

/**
 * Отвечает за общие действия для всего экрана(например показ снекбара)
 */
class MainReducer: Reducer<MviExampleState, MviExampleIntent, MviExampleEffect> {
    override fun invoke(
        state: MviExampleState,
        intent: MviExampleIntent
    ): ReducerResult<MviExampleState, MviExampleEffect> =
        when (intent) {
            MviExampleIntent.OpenScreen -> ReducerResult(
                state = state,
                effects = listOf(MviExampleEffect.ShowSnackbar("Экран открыт"))
            )
            MviExampleIntent.Decrement -> ReducerResult(
                state = state,
                effects = listOf(MviExampleEffect.ShowSnackbar("Decrement clicked"))
            )
            MviExampleIntent.Increment -> ReducerResult(
                state = state,
                effects = listOf(MviExampleEffect.ShowSnackbar("Increment clicked"))
            )

            else -> ReducerResult(state = state, effects = emptyList())
        }
}