package com.example.composebasics_state_screen_handling.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composebasics_state_screen_handling.LoginState
import com.example.composebasics_state_screen_handling.NavigationData
import com.example.composebasics_state_screen_handling.ui.LoginViewModel
import com.example.composebasics_state_screen_handling.ui.theme.ComposeBasics_State_Screen_HandlingTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreenRoot(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = koinViewModel(),
    onLoginSuccess: (NavigationData) -> Unit
) {
    LoginScreen(
        state = viewModel.state,
        onLoginSuccess = {
            onLoginSuccess(
                NavigationData(true, "Michl Muster", 78)
            )
        },
        onUserMailChanged = {
            viewModel.onUserMailChanged(it)
        }
    )
}

@Composable
fun LoginScreen(
    state: LoginState,
    onLoginSuccess: () -> Unit,
    onUserMailChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.Center)
        ) {
            TextField(
                value = state.userMail,
                onValueChange = onUserMailChanged,
                enabled = true,
                modifier = Modifier.background(Color.White)
            )

            Spacer(Modifier.height(8.dp))

            Button(
                onClick = onLoginSuccess,
            ) {
                Text(text = "Login")
            }
        }

        Text(
            text = state.text,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

//TODO create preview
