package com.example.myapplicationfragmentandmvvm.ui.main

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.myapplicationfragmentandmvvm.repository.MyRepository

class MainViewModel @ViewModelInject constructor(
        myRepository: MyRepository
) : ViewModel() {

    init {
         Log.d("qqq", "MVVM and repo: ${myRepository.getInfo()}")
    }
}