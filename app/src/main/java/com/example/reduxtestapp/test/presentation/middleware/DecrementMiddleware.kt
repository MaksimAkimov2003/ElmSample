package com.example.reduxtestapp.test.presentation.middleware

import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.state.MviExampleState
import kotlinx.coroutines.delay

const val DELAY = 5000L

class DecrementMiddleware : Middleware<MviExampleState, MviExampleIntent> {

    override suspend fun handleIntent(
        state: MviExampleState,
        intent: MviExampleIntent
    ): MviExampleIntent {
        if (intent !is MviExampleIntent.Decrement) {
            return intent
        }
        // Имитация какой-то долгой работы, сетевого запроса и т.д.
        delay(DELAY)

        return MviExampleIntent.CounterValueUpdated(state.counter - 1)
    }
}