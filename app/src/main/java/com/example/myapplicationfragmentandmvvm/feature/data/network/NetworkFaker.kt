package com.example.myapplicationfragmentandmvvm.feature.data.network

import rx.Single

class NetworkFaker constructor() {
    fun getDataFromServerForFeature() = Single.just("data from Network")

//    fun getDataFromServerForFeature() = Single.error<String>(IOException("oops"))
}