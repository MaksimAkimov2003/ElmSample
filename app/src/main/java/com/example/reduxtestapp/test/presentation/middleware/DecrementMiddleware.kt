package com.example.reduxtestapp.test.presentation.middleware

import com.example.reduxtestapp.test.presentation.effect.MviExampleEffect
import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.state.MviExampleState
import kotlinx.coroutines.delay

class DecrementMiddleware : Middleware<MviExampleState, MviExampleIntent, MviExampleEffect> {

    override suspend fun handleIntent(
        state: MviExampleState,
        intent: MviExampleIntent
    ): Pair<MviExampleIntent, MviExampleEffect?> {
        if (intent !is MviExampleIntent.Decrement) {
            return intent to null
        }
        // Имитация какой-то долгой работы, сетевого запроса и т.д.
        delay(1000)

        return MviExampleIntent.CounterValueUpdated(state.counter - 1) to MviExampleEffect.ShowSnackbar("Decrement clicked")
    }
}