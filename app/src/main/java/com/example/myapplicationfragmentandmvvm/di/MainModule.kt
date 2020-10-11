package com.example.myapplicationfragmentandmvvm.di

import com.example.myapplicationfragmentandmvvm.feature.data.database.DatabaseFaker
import toothpick.config.Module

class MainModule() : Module() {
    init {
//        bind(Application::class.java).toInstance(application)
//        bind(String::class.java).toInstance("Hello World")

        bind(DatabaseFaker::class.java).to(DatabaseFaker::class.java).singleton()
//        bind(NetworkFaker::class.java).toInstance(NetworkFaker())
//
//        bind(MyLocalDataSource::class.java)
//        bind(MyRemoteDataSource::class.java)
//
//        bind(MyRepository::class.java)
//
//        bind(ViewModelFactory::class.java).singleton()

    }
}