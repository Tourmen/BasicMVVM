package com.example.myapplicationfragmentandmvvm.repository

import javax.inject.Inject

class MyRepository @Inject constructor() {

    fun getInfo() = "From repo"
}