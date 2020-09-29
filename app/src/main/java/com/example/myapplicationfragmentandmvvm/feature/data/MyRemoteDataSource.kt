package com.example.myapplicationfragmentandmvvm.feature.data

import com.example.myapplicationfragmentandmvvm.feature.data.network.NetworkFaker

class MyRemoteDataSource constructor(
    val networkFaker: NetworkFaker
) {

    fun getDataFromNetwork() = networkFaker.getDataFromServerForFeature()
}