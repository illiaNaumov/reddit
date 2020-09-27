package com.naumov.reddit

import android.app.Application
import com.naumov.reddit.di.appModule
import com.naumov.reddit.di.networkModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            modules(listOf(appModule, networkModule))
        }
    }
}