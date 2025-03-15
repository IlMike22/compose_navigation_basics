package com.example.composebasics_state_screen_handling.ui.overview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.composebasics_state_screen_handling.ui.OverviewRoute

class OverviewViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    var state by mutableStateOf(OverviewState())
        private set

    private val args = savedStateHandle.toRoute<OverviewRoute>()

    init {
        state = state.copy(
            welcomeTitle = "Welcome ${args.name}",
            subtitle = "You are ${args.age} years old and successfully logged in."
        )

    }
}