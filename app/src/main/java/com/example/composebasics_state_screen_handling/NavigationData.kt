package com.example.composebasics_state_screen_handling

import kotlinx.serialization.Serializable

@Serializable
data class NavigationData(
    val isLoggedIn: Boolean,
    val name: String,
    val age: Int
)