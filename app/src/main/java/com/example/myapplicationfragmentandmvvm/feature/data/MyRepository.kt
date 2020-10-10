package com.example.myapplicationfragmentandmvvm.feature.data

import android.util.Log
import com.example.myapplicationfragmentandmvvm.di.customModule
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

class MyRepository constructor(
    private val myLocalDataSource: MyLocalDataSource,
    private val myRemoteDataSource: MyRemoteDataSource
) {
    val kodein = Kodein {
        import(customModule)
    }

    val customClass: CustomClass by kodein.instance()

    fun getInfoForFeature() = myRemoteDataSource.getDataFromNetwork()
        .doOnSuccess {
            customClass.test()
        }
        .onErrorResumeNext {
            Log.d("qqq", "MyRepository exc: ${it.message}")
            myLocalDataSource.getLocalDataForFeature()
        }
}