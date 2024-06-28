package com.example.reduxtestapp.test.presentation.middleware

import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.state.MviExampleState
import kotlinx.coroutines.delay

class IncrementMiddleware : Middleware<MviExampleState, MviExampleIntent> {

    override suspend fun invoke(
        state: MviExampleState,
        intent: MviExampleIntent
    ): MviExampleIntent? {
        if (intent !is MviExampleIntent.Increment) {
            return null
        }
        delay(DELAY)
        return MviExampleIntent.CounterValueUpdated(state.counter + 1)
    }
}