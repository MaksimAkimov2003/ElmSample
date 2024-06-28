package com.example.reduxtestapp.test.presentation.middleware

import com.example.reduxtestapp.test.presentation.effect.MviExampleEffect
import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.state.MviExampleState
import kotlinx.coroutines.delay

class IncrementMiddleware : Middleware<MviExampleState, MviExampleIntent, MviExampleEffect> {

    override suspend fun handleIntent(
        state: MviExampleState,
        intent: MviExampleIntent
    ): MiddlewareResult<MviExampleIntent, MviExampleEffect> {
        when (intent) {
            is MviExampleIntent.Increment -> return MiddlewareResult(
                intent = MviExampleIntent.IncrementStarted,
                effects = listOf(MviExampleEffect.ShowSnackbar("Increment started"))
            )

            !is MviExampleIntent.IncrementStarted -> return MiddlewareResult(intent = intent)
            else -> {}
        }

        delay(DELAY)
        return MiddlewareResult(
            intent = MviExampleIntent.CounterValueUpdated(state.counter + 1)
        )
    }
}