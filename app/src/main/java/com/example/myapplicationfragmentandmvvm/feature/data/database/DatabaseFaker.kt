package com.example.myapplicationfragmentandmvvm.feature.data.database

import rx.Single

class DatabaseFaker constructor(){

    fun getSomeDataForFeature() = Single.just("data from DB")
}