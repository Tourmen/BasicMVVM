package com.example.myapplicationfragmentandmvvm.feature

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.myapplicationfragmentandmvvm.feature.data.MyRepository
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MyViewModel @ViewModelInject constructor(
    myRepository: MyRepository,
    val myViewModelState: MyViewModelState
) : ViewModel() {

    init {
        myRepository.getInfoForFeature()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { resultFromRepo ->
                Log.d("qqq", "got from repo: $resultFromRepo")
                myViewModelState.textField.value = resultFromRepo
            }
    }

}