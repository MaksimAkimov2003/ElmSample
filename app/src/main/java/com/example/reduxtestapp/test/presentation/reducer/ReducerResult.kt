package com.example.reduxtestapp.test.presentation.reducer

import com.example.reduxtestapp.test.presentation.effect.MviEffect
import com.example.reduxtestapp.test.presentation.state.MviState

/**
 * Результат работы редьюсера - новый стейт и эффекты
 */
data class ReducerResult<State: MviState, Effect: MviEffect>(
    val state: State,
    val effects: List<Effect> = emptyList()
)
