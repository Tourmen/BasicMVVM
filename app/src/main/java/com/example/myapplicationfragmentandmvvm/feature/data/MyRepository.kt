package com.example.myapplicationfragmentandmvvm.feature.data

import android.util.Log
import javax.inject.Inject

class MyRepository @Inject constructor(
    private val myLocalDataSource: MyLocalDataSource,
    private val myRemoteDataSource: MyRemoteDataSource
) {

    fun getInfoForFeature() = myRemoteDataSource.getDataFromNetwork()
        .doOnSuccess {


        }
        .onErrorResumeNext {
            Log.d("qqq", "MyRepository exc: ${it.message}")
            myLocalDataSource.getLocalDataForFeature()
        }
}