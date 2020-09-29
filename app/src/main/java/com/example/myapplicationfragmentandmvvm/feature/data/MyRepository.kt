package com.example.myapplicationfragmentandmvvm.feature.data

import android.util.Log
import org.koin.core.KoinComponent
import org.koin.java.KoinJavaComponent.inject

class MyRepository constructor(
    private val myLocalDataSource: MyLocalDataSource,
    private val myRemoteDataSource: MyRemoteDataSource
): KoinComponent {
    private val customClass by inject(CustomClass::class.java)

    fun getInfoForFeature() = myRemoteDataSource.getDataFromNetwork()
        .doOnSuccess {
            customClass.test()
            // save to DB
        }
        .onErrorResumeNext {
            Log.d("qqq", "MyRepository exc: ${it.message}")
            myLocalDataSource.getLocalDataForFeature()
        }
}