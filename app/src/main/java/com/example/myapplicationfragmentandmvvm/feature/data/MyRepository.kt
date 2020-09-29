package com.example.myapplicationfragmentandmvvm.feature.data

import android.util.Log
import org.koin.core.KoinComponent
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.inject

class MyRepository constructor(
    private val myLocalDataSource: MyLocalDataSource,
    private val myRemoteDataSource: MyRemoteDataSource
): KoinComponent {
//    private val customClass by inject(CustomClass::class.java)

    fun getInfoForFeature() = myRemoteDataSource.getDataFromNetwork()
        .doOnSuccess {
            val scope = getKoin().getOrCreateScope("sessionID", named("session"))
            val customClass = scope.getScope("sessionID").get<CustomClass>()
            customClass.test()
            scope.close()
        }
        .onErrorResumeNext {
            Log.d("qqq", "MyRepository exc: ${it.message}")
            myLocalDataSource.getLocalDataForFeature()
        }
}