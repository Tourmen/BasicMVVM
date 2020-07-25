package com.example.myapplicationfragmentandmvvm.feature.data

import com.example.myapplicationfragmentandmvvm.feature.data.network.NetworkFaker
import javax.inject.Inject

class MyRemoteDataSource @Inject constructor(
    val networkFaker: NetworkFaker
) {

    fun getDataFromNetwork() = networkFaker.getDataFromServerForFeature()
}