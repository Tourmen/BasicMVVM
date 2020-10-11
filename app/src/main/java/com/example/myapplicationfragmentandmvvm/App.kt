package com.example.myapplicationfragmentandmvvm

import android.app.Application
import com.example.myapplicationfragmentandmvvm.di.MainModule
import toothpick.Scope
import toothpick.Toothpick

class App : Application() {

    companion object {
        lateinit var app: App
    }


    override fun onCreate() {
        super.onCreate()

//        val appScope: Scope = Toothpick.openScope(this)
//
//        appScope.installModules(MainModule(this))
//        Toothpick.inject(this, appScope)

        val appScope = Toothpick.openScope("APP")
        appScope.installModules(MainModule())

    }
}