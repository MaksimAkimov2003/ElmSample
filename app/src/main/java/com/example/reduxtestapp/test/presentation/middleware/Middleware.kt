package com.example.reduxtestapp.test.presentation.middleware

import com.example.reduxtestapp.test.presentation.intent.MviIntent
import com.example.reduxtestapp.test.presentation.state.MviState

/**
 * Обрабатывает результаты выполнения useCas'ов, отвечает за работу с доменным слоем
 * @return новый Intent, который будет отправлен в Reducer
 * @param юзкейсы
 */
interface Middleware<State : MviState, Intent : MviIntent> {

    suspend operator fun invoke(state: State, intent: Intent): Intent?
}