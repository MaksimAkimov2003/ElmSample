package com.example.reduxtestapp.test.presentation.middleware

import com.example.reduxtestapp.test.presentation.effect.MviEffect
import com.example.reduxtestapp.test.presentation.intent.MviIntent

data class MiddlewareResult<Intent : MviIntent, Effect : MviEffect>(
    val intent: Intent,
    val effects: List<Effect> = emptyList(),
)
