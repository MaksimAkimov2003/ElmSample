package com.example.reduxtestapp.test

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.reduxtestapp.test.presentation.effect.MviExampleEffect
import com.example.reduxtestapp.test.presentation.intent.MviExampleIntent
import com.example.reduxtestapp.test.presentation.middleware.DecrementMiddleware
import com.example.reduxtestapp.test.presentation.middleware.IncrementMiddleware
import com.example.reduxtestapp.test.presentation.middleware.OpenScreenMiddleware
import com.example.reduxtestapp.test.presentation.reducer.ButtonStateReducer
import com.example.reduxtestapp.test.presentation.reducer.CounterReducer
import com.example.reduxtestapp.test.presentation.state.MviExampleState
import com.example.reduxtestapp.test.presentation.viewModel.MviExampleViewModel

@Composable
fun MviExampleScreen() {
    val viewModel = remember {
        MviExampleViewModel(
            reducers = setOf(CounterReducer(), ButtonStateReducer()),
            middlewares = setOf(
                IncrementMiddleware(), DecrementMiddleware(), OpenScreenMiddleware()
            ),
        )
    }

    val state by viewModel.state.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is MviExampleEffect.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(message = effect.message)
                }
            }

        }
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.dispatch(MviExampleIntent.OpenScreen)
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) {
                Snackbar(
                    snackbarData = it,
                    modifier = Modifier.clickable { it.dismiss() },
                )
            }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Text(
                text = "Counter value: ${state.counter}",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {
                    if (state.buttonsState == MviExampleState.ButtonsState.IDLE) {
                        viewModel.dispatch(MviExampleIntent.Increment)
                    }
                }) {
                    when (state.buttonsState) {
                        MviExampleState.ButtonsState.LOADING -> CircularProgressIndicator(
                        )

                        MviExampleState.ButtonsState.IDLE -> Text(text = "Increment")
                    }
                }
                Button(onClick = {
                    if (state.buttonsState == MviExampleState.ButtonsState.IDLE) {
                        viewModel.dispatch(MviExampleIntent.Decrement)
                    }
                }) {
                    when (state.buttonsState) {
                        MviExampleState.ButtonsState.LOADING -> CircularProgressIndicator(
                        )

                        MviExampleState.ButtonsState.IDLE -> Text(text = "Decrement")
                    }
                }
            }
        }
    }
}

