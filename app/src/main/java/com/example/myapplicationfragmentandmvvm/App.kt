package com.example.myapplicationfragmentandmvvm

import android.app.Application
import com.example.myapplicationfragmentandmvvm.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        lateinit var app: App
    }


    override fun onCreate() {
        super.onCreate()

        // start Koin!
        startKoin {
            // Android context
            androidContext(this@App)
            // modules
            modules(appModule)
        }
    }
}