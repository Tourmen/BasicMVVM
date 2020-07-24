package com.example.myapplicationfragmentandmvvm.di

import com.example.myapplicationfragmentandmvvm.feature.data.MyLocalDataSource
import com.example.myapplicationfragmentandmvvm.feature.data.MyRemoteDataSource
import com.example.myapplicationfragmentandmvvm.feature.data.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun provideRepo(myLocalDataSource: MyLocalDataSource, myRemoteDataSource: MyRemoteDataSource) : MyRepository {
        return MyRepository(myLocalDataSource, myRemoteDataSource)
    }
}