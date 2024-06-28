package com.example.reduxtestapp.test.presentation.intent

sealed class MviExampleIntent : MviIntent {

    data object OpenScreen: MviExampleIntent()

    data object Increment : MviExampleIntent()

    data object Decrement : MviExampleIntent()

    class CounterValueUpdated(val newValue: Int) : MviExampleIntent()
}