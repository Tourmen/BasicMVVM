package com.example.myapplicationfragmentandmvvm.feature.data

import com.example.myapplicationfragmentandmvvm.feature.data.database.DatabaseFaker
import javax.inject.Inject

class MyLocalDataSource @Inject constructor(
    val databaseFaker: DatabaseFaker
) {

    fun getLocalDataForFeature() = databaseFaker.getSomeDataForFeature()

}