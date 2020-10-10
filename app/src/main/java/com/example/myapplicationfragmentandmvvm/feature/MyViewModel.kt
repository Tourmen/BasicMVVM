package com.example.myapplicationfragmentandmvvm.feature

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val repository: MyRepository,
    private val state: MyViewModelState
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(repository, state) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}