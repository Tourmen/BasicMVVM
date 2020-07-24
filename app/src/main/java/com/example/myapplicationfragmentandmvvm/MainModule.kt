package com.example.myapplicationfragmentandmvvm

import com.example.myapplicationfragmentandmvvm.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun provideRepo() = MyRepository()
}