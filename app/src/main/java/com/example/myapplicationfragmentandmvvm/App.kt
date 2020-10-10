package com.example.myapplicationfragmentandmvvm

import android.app.Application
import com.example.myapplicationfragmentandmvvm.feature.MyViewModelState
import com.example.myapplicationfragmentandmvvm.feature.ViewModelFactory
import com.example.myapplicationfragmentandmvvm.feature.data.MyLocalDataSource
import com.example.myapplicationfragmentandmvvm.feature.data.MyRemoteDataSource
import com.example.myapplicationfragmentandmvvm.feature.data.MyRepository
import com.example.myapplicationfragmentandmvvm.feature.data.database.DatabaseFaker
import com.example.myapplicationfragmentandmvvm.feature.data.network.NetworkFaker
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class App : Application(), KodeinAware {

    override val kodein by Kodein.lazy {

        bind<NetworkFaker>() with singleton { NetworkFaker() }
        bind<DatabaseFaker>() with singleton { DatabaseFaker() }

        bind<MyRemoteDataSource>() with singleton { MyRemoteDataSource(instance()) }
        bind<MyLocalDataSource>() with singleton { MyLocalDataSource(instance()) }

        bind<MyRepository>() with singleton {
            MyRepository(
                MyLocalDataSource(instance()),
                MyRemoteDataSource(instance())
            )
        }

        bind<MyViewModelState>() with singleton { MyViewModelState() }

        bind<ViewModelFactory>() with singleton { ViewModelFactory(instance(), instance()) }

    }

    companion object {
        lateinit var app: App
    }

    override fun onCreate() {
        super.onCreate()

    }
}