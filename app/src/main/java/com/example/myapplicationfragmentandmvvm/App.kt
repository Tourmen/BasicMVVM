package com.example.myapplicationfragmentandmvvm

import android.app.Application
import com.example.myapplicationfragmentandmvvm.repository.MyRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var app: App
    }

    init {


    }
}