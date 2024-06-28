package com.example.reduxtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.reduxtestapp.test.MviExampleScreen
import com.example.reduxtestapp.ui.theme.ReduxTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReduxTestAppTheme {
                MviExampleScreen()
            }
        }
    }
}