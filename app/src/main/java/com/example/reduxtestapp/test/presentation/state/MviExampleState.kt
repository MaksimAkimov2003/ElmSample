package com.example.reduxtestapp.test.presentation.state

data class MviExampleState(
    val counter: Int = 0,
    val buttonsState: ButtonsState = ButtonsState.IDLE,
) : MviState {

    enum class ButtonsState {

        LOADING, IDLE,
    }
}