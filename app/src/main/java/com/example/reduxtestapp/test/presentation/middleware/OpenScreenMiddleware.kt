package com.example.reduxtestapp.test.presentation.middleware

import com.example.reduxtestapp.test.presentation.effect.MviExampleEffect
import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.state.MviExampleState

class OpenScreenMiddleware : Middleware<MviExampleState, MviExampleIntent, MviExampleEffect> {
    override suspend fun handleIntent(
        state: MviExampleState,
        intent: MviExampleIntent
    ): MiddlewareResult<MviExampleIntent, MviExampleEffect> {
        if (intent !is MviExampleIntent.OpenScreen) {
            return MiddlewareResult(
                intent = intent,
            )
        }

        return MiddlewareResult(
            intent = intent,
            effects = listOf(MviExampleEffect.ShowSnackbar("Open screen"))
        )
    }
}