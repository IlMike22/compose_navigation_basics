package com.example.composebasics_state_screen_handling

import android.app.Application
import com.example.composebasics_state_screen_handling.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ComposeBasicsApplication:Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
            androidContext(this@ComposeBasicsApplication)
        }
    }

}