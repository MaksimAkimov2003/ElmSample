package com.example.reduxtestapp.test.presentation.effect

sealed class MviExampleEffect: MviEffect {
    data class ShowSnackbar(val message: String) : MviExampleEffect()
}