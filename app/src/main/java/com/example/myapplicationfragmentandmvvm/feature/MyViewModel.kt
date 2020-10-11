package com.example.myapplicationfragmentandmvvm.feature

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationfragmentandmvvm.App
import com.example.myapplicationfragmentandmvvm.feature.data.MyRepository
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import toothpick.Toothpick
import javax.inject.Inject
import javax.inject.Singleton

class MyViewModel @Inject constructor(
    val myRepository: MyRepository,
    val myViewModelState: MyViewModelState
): ViewModel() {

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

//@Singleton
//class ViewModelFactory @Inject constructor(val app: Application):
//    ViewModelProvider.NewInstanceFactory() {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>) =
//        Toothpick.openScope(app).getInstance(modelClass) as T
//
//}

@Singleton
class ViewModelFactory @Inject constructor() :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        Toothpick.openScope(App::class.java).getInstance(modelClass) as T
}