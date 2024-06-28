package com.example.reduxtestapp.test.presentation.middleware

import com.example.reduxtestapp.test.presentation.effect.MviExampleEffect
import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.state.MviExampleState

class OpenScreenMiddleware: Middleware<MviExampleState, MviExampleIntent, MviExampleEffect>{
    override suspend fun handleIntent(
        state: MviExampleState,
        intent: MviExampleIntent
    ): Pair<MviExampleIntent, MviExampleEffect?> {
        if (intent !is MviExampleIntent.OpenScreen) {
            return intent to null
        }

        return intent to MviExampleEffect.ShowSnackbar("Экран открыт")
    }
}