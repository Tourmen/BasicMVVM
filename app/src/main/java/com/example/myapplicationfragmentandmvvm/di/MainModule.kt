package com.example.myapplicationfragmentandmvvm.di

import com.example.myapplicationfragmentandmvvm.feature.data.MyLocalDataSource
import com.example.myapplicationfragmentandmvvm.feature.data.MyRemoteDataSource
import com.example.myapplicationfragmentandmvvm.feature.data.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Singleton

@Module
@InstallIn(FragmentComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun provideRepo(
        myLocalDataSource: MyLocalDataSource,
        myRemoteDataSource: MyRemoteDataSource
    ): MyRepository {
        return MyRepository(myLocalDataSource, myRemoteDataSource)
    }
}