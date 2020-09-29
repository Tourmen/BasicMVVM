package com.example.myapplicationfragmentandmvvm.di

import com.example.myapplicationfragmentandmvvm.feature.MyViewModel
import com.example.myapplicationfragmentandmvvm.feature.MyViewModelState
import com.example.myapplicationfragmentandmvvm.feature.data.MyLocalDataSource
import com.example.myapplicationfragmentandmvvm.feature.data.MyRemoteDataSource
import com.example.myapplicationfragmentandmvvm.feature.data.MyRepository
import com.example.myapplicationfragmentandmvvm.feature.data.database.DatabaseFaker
import com.example.myapplicationfragmentandmvvm.feature.data.network.NetworkFaker
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // single instance of HelloRepository (which will be reused)
    viewModel { MyViewModel(get(), get()) }

    single { MyRepository(get(), get()) }

    single { MyLocalDataSource(get()) }
    single { DatabaseFaker() }

    single { MyRemoteDataSource(get()) }
    single { NetworkFaker() }

    single { MyViewModelState() }

    // Simple Presenter Factory (creates every time new)
    // factory { MyPresenter(get()) }
}