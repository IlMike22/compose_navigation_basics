package com.example.composebasics_state_screen_handling.di

import com.example.composebasics_state_screen_handling.ComposeBasicsApplication
import com.example.composebasics_state_screen_handling.ui.LoginRoute
import com.example.composebasics_state_screen_handling.ui.login.LoginViewModel
import com.example.composebasics_state_screen_handling.ui.overview.OverviewViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<CoroutineScope> {
        (androidApplication() as ComposeBasicsApplication).applicationScope
    }

    viewModelOf(::LoginViewModel)
    viewModelOf(::OverviewViewModel)
}