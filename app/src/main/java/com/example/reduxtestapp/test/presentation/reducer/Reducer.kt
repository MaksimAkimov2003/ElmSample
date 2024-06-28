package com.example.reduxtestapp.test.presentation.reducer

import com.example.reduxtestapp.test.presentation.effect.MviEffect
import com.example.reduxtestapp.test.presentation.intent.MviIntent
import com.example.reduxtestapp.test.presentation.state.MviState

/**
 * Обновляет пользовательский интерфейс - стейт экрана и эффекты
 */
interface Reducer<State : MviState, Intent : MviIntent, Effect: MviEffect> {

    operator fun invoke(state: State, intent: Intent): ReducerResult<State, Effect>
}