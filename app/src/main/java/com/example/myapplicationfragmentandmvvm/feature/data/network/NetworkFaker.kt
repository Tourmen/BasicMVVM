package com.example.myapplicationfragmentandmvvm.feature.data.network

import rx.Single
import java.io.IOException
import javax.inject.Inject

class NetworkFaker @Inject constructor() {
    fun getDataFromServerForFeature() = Single.just("data from Network")

//    fun getDataFromServerForFeature() = Single.error<String>(IOException("oops"))
}