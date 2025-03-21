package com.example.composebasics_state_screen_handling

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.composebasics_state_screen_handling.ui.AuthRoute
import com.example.composebasics_state_screen_handling.ui.LoginRoute
import com.example.composebasics_state_screen_handling.ui.login.LoginScreenRoot
import com.example.composebasics_state_screen_handling.ui.MainRoute
import com.example.composebasics_state_screen_handling.ui.OverviewRoute
import com.example.composebasics_state_screen_handling.ui.overview.OverviewScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AuthRoute
    ) {
        authGraph(navController)
        mainGraph()
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation<AuthRoute>(startDestination = LoginRoute)
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
                        popUpTo(AuthRoute) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

private fun NavGraphBuilder.mainGraph() {
    navigation<MainRoute>(startDestination = OverviewRoute()) {
        composable<OverviewRoute> {
            val args = it.toRoute<OverviewRoute>()
            OverviewScreenRoot()
        }
    }
}