package com.example.myapplicationfragmentandmvvm.feature.data.database

import rx.Single
import javax.inject.Inject

class DatabaseFaker @Inject constructor(){

    fun getSomeDataForFeature() = Single.just("data from DB")
}