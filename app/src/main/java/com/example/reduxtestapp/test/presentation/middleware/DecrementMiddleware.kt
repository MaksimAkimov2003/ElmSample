package com.example.reduxtestapp.test.presentation.middleware

import com.example.reduxtestapp.test.presentation.effect.MviExampleEffect
import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.state.MviExampleState
import kotlinx.coroutines.delay

const val DELAY = 5000L

class DecrementMiddleware : Middleware<MviExampleState, MviExampleIntent, MviExampleEffect> {

    override suspend fun handleIntent(
        state: MviExampleState,
        intent: MviExampleIntent
    ): MiddlewareResult<MviExampleIntent, MviExampleEffect> {
        when (intent) {
            is MviExampleIntent.Decrement -> return MiddlewareResult(
                intent = MviExampleIntent.DecrementStarted,
                effects = listOf(MviExampleEffect.ShowSnackbar("Decrement started"))
            )

            !is MviExampleIntent.DecrementStarted -> return MiddlewareResult(intent = intent)
            else -> {}
        }
        // Имитация какой-то долгой работы, сетевого запроса и т.д.
        delay(DELAY)
        return MiddlewareResult(
            intent = MviExampleIntent.CounterValueUpdated(state.counter - 1)
        )
    }
}