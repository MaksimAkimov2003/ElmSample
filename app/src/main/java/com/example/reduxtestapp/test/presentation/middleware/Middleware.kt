package com.example.reduxtestapp.test.presentation.middleware

import com.example.reduxtestapp.test.presentation.effect.MviEffect
import com.example.reduxtestapp.test.presentation.intent.MviIntent
import com.example.reduxtestapp.test.presentation.state.MviState

interface Middleware<State : MviState, Intent : MviIntent, Effect : MviEffect> {

    suspend fun handleIntent(state: State, intent: Intent): MiddlewareResult<Intent, Effect>
}