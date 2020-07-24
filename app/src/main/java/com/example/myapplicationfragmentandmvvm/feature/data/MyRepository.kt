package com.example.myapplicationfragmentandmvvm.feature.data

import javax.inject.Inject

class MyRepository @Inject constructor(
    val myLocalDataSource: MyLocalDataSource,
    val myRemoteDataSource: MyRemoteDataSource
) {

    fun getInfo() = "From repo"
}