package com.example.myapplicationfragmentandmvvm.feature

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.myapplicationfragmentandmvvm.feature.data.MyRepository

class MyViewModel @ViewModelInject constructor(
        myRepository: MyRepository
) : ViewModel() {

    init {
         Log.d("qqq", "MVVM and repo: ${myRepository.getInfo()}")
    }
}