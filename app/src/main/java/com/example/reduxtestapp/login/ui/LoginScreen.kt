//package com.example.reduxtestapp.login.ui
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.reduxtestapp.login.presentation.state.LoginScreenState
//
//@Composable
//fun LoginScreen() {
//    LoginScreenStateless(
//        state = LoginScreenState(
//            username = "username",
//            isLoading = false,
//        ),
//        onInputUserName = {},
//    )
//}
//
//@Composable
//private fun LoginScreenStateless(
//    state: LoginScreenState,
//    onInputUserName: (String) -> Unit,
//    onLoginClicked: () -> Unit,
//) {
//    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Spacer(modifier = Modifier.height(16.dp))
//            TextField(
//                value = state.username,
//                onValueChange = onInputUserName,
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp)
//                    .padding(horizontal = 16.dp),
//                onClick = onLoginClicked
//            ) {
//                if (state.isLoading) {
//                    CircularProgressIndicator()
//                }
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//private fun LoginScreenPreview() {
//    LoginScreenStateless(
//        state = LoginScreenState(
//            username = "username",
//            isLoading = false,
//        ),
//        onInputUserName = {},
//
//        )
//}