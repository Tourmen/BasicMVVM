package com.example.myapplicationfragmentandmvvm.feature.data

import javax.inject.Inject

class MyRepository @Inject constructor(
    private val myLocalDataSource: MyLocalDataSource,
    private val myRemoteDataSource: MyRemoteDataSource
) {

    fun getInfoForFeature() = myRemoteDataSource.getDataFromNetwork()
        .doOnSuccess {
            // save to DB
        }
        .onErrorResumeNext {
            myLocalDataSource.getLocalDataForFeature()
        }
}