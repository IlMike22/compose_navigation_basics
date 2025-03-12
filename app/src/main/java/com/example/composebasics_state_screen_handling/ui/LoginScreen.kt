package com.example.composebasics_state_screen_handling.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composebasics_state_screen_handling.LoginState
import com.example.composebasics_state_screen_handling.NavigationData
import com.example.composebasics_state_screen_handling.ui.theme.ComposeBasics_State_Screen_HandlingTheme

@Composable
fun LoginScreenRoot(
    modifier: Modifier = Modifier,
    onLoginSuccess: (NavigationData) -> Unit
) {
    val viewModel = viewModel<LoginViewModel>()

    LoginScreen(
        state = viewModel.state,
        onLoginSuccess = {
            onLoginSuccess(
                NavigationData(true, "John Doe", 22)
            )
        }
    )
}

@Composable
fun LoginScreen(
    state: LoginState,
    onLoginSuccess: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()

    ) {
        Text(
            text = state.text,
            color = Color.Black,
            modifier = Modifier.align(
                Alignment.BottomCenter
            )
        )

        Button(
            onClick = { onLoginSuccess() },
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(text = "Login")
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    ComposeBasics_State_Screen_HandlingTheme {
        LoginScreen(
            LoginState(
                text = "hello login",
            ),
            onLoginSuccess = {}
        )
    }
}