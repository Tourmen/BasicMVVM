package com.example.myapplicationfragmentandmvvm.feature.data

import android.util.Log
import javax.inject.Inject

class CustomClass @Inject constructor() {

    fun test() {
        Log.d("qqq", "test from CustomClass: $this")
    }
}