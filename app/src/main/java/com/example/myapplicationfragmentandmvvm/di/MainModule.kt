package com.example.myapplicationfragmentandmvvm.di

import com.example.myapplicationfragmentandmvvm.feature.data.CustomClass
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

val  customModule = Kodein.Module(name = "Custom") {
    bind<CustomClass>() with singleton { CustomClass() }
}