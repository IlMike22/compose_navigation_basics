package com.example.composebasics_state_screen_handling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.composebasics_state_screen_handling.ui.theme.ComposeBasics_State_Screen_HandlingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeBasics_State_Screen_HandlingTheme {
                val navController = rememberNavController()
                NavigationRoot(navController)
            }
        }
    }
}

