package com.example.myapplicationfragmentandmvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationfragmentandmvvm.feature.MainFragment
import com.example.myapplicationfragmentandmvvm.feature.data.database.DatabaseFaker
import toothpick.Toothpick
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var databaseFaker: DatabaseFaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
        val appScope = Toothpick.openScope("APP")
        Toothpick.inject(this, appScope)

        databaseFaker.getSomeDataForFeature()

        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}