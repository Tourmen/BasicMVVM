package com.example.myapplicationfragmentandmvvm.feature

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class MyViewModelState @Inject constructor(){

    val textField = MutableLiveData("")
}