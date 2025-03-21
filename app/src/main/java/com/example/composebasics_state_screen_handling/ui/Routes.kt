package com.example.composebasics_state_screen_handling.ui

import kotlinx.serialization.Serializable


@Serializable
data object AuthRoute

@Serializable
data object MainRoute

@Serializable
data object LoginRoute

@Serializable
data class OverviewRoute(
    val isLoggedIn: Boolean = false,
    val name: String = "",
    val age: Int = 0
)