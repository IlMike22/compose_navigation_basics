package com.example.composebasics_state_screen_handling.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OverviewViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    var state by mutableStateOf(OverviewState())
        private set

//    private val _state = MutableStateFlow(OverviewState())
//    val state = _state.asStateFlow()

    val args = savedStateHandle.toRoute<OverviewRoute>()

    init {

        state = state.copy(
            welcomeTitle = "Welcome ${args.name}",
            subtitle = "You are ${args.age} years old and successfully logged in."
        )

//        _state.update {
//            it.copy(
//                welcomeTitle = "Welcome ${args.name}",
//                subtitle = "You are ${args.age} years old and successfully logged in."
//            )
//        }
    }
}