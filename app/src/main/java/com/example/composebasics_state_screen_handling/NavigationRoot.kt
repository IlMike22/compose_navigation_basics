package com.example.composebasics_state_screen_handling

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.composebasics_state_screen_handling.ui.AuthRootRoute
import com.example.composebasics_state_screen_handling.ui.LoginRoute
import com.example.composebasics_state_screen_handling.ui.login.LoginScreenRoot
import com.example.composebasics_state_screen_handling.ui.MainRootRoute
import com.example.composebasics_state_screen_handling.ui.OverviewRoute
import com.example.composebasics_state_screen_handling.ui.overview.OverviewScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AuthRootRoute
    ) {
        authGraph(navController)
        mainGraph()
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation<AuthRootRoute>(startDestination = LoginRoute)
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
                        popUpTo(AuthRootRoute) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

private fun NavGraphBuilder.mainGraph() {
    navigation<MainRootRoute>(startDestination = OverviewRoute()) {
        composable<OverviewRoute> {
            val args = it.toRoute<OverviewRoute>()

            OverviewScreenRoot()
        }
    }
}