package com.example.myapplicationfragmentandmvvm.feature

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplicationfragmentandmvvm.feature.data.MyRepository
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class MyViewModel constructor(
    val myRepository: MyRepository,
    val myViewModelState: MyViewModelState
) : ViewModel() {

    fun callRepo() {
        Log.d("qqq", "MyViewModel callRepo myRepository: $myRepository")
        myRepository.getInfoForFeature()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { resultFromRepo ->
                Log.d("qqq", "got from repo: $resultFromRepo")
                myViewModelState.textField.value = resultFromRepo
            }
    }

}