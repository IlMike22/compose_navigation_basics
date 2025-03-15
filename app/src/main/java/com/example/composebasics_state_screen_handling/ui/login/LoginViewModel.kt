package com.example.composebasics_state_screen_handling.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    init {
        state = state.copy(text = "Login")
    }

    fun onUserMailChanged(userMail:String) {
        state = state.copy(userMail = userMail)
    }

    fun onLoginSuccess() {
        // handle login success
    }
}