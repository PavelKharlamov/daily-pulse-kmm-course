package com.petros.efthymiou.dailypulse.android

import android.app.Application
import com.petros.efthymiou.dailypulse.android.di.databaseModule
import com.petros.efthymiou.dailypulse.android.di.viewModelsModule
import com.petros.efthymiou.dailypulse.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = databaseModule + sharedKoinModules + viewModelsModule

        startKoin {
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}