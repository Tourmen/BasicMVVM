package com.example.myapplicationfragmentandmvvm.feature.data

import com.example.myapplicationfragmentandmvvm.feature.data.database.DatabaseFaker

class MyLocalDataSource constructor(
    val databaseFaker: DatabaseFaker
) {

    fun getLocalDataForFeature() = databaseFaker.getSomeDataForFeature()

}