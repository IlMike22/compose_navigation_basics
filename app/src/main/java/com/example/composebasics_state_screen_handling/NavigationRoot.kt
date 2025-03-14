package com.example.composebasics_state_screen_handling

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.composebasics_state_screen_handling.ui.AuthRoot
import com.example.composebasics_state_screen_handling.ui.LoginRoute
import com.example.composebasics_state_screen_handling.ui.login.LoginScreenRoot
import com.example.composebasics_state_screen_handling.ui.MainRoot
import com.example.composebasics_state_screen_handling.ui.OverviewRoute

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AuthRoot
    ) {
        authGraph(navController)
        mainGraph()
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation<AuthRoot>(startDestination = LoginRoute)
    {
        composable<LoginRoute> {
            LoginScreenRoot(
                onLoginSuccess = { navigationData ->
                    navController.navigate(
                        OverviewRoute(
                            isLoggedIn = navigationData.isLoggedIn,
                            name = navigationData.name,
                            age = navigationData.age
                        )
                    ) {
                        popUpTo(AuthRoot) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

private fun NavGraphBuilder.mainGraph() {
    navigation<MainRoot>(startDestination = OverviewRoute()) {
        composable<OverviewRoute> {
            val args = it.toRoute<OverviewRoute>()

            OverviewScreenRoot()
        }
    }
}