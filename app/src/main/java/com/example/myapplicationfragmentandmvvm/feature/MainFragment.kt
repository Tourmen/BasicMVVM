package com.example.myapplicationfragmentandmvvm.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.myapplicationfragmentandmvvm.R
import com.example.myapplicationfragmentandmvvm.feature.data.MyLocalDataSource
import com.example.myapplicationfragmentandmvvm.feature.data.MyRemoteDataSource
import com.example.myapplicationfragmentandmvvm.feature.data.MyRepository
import com.example.myapplicationfragmentandmvvm.feature.data.database.DatabaseFaker
import com.example.myapplicationfragmentandmvvm.feature.data.network.NetworkFaker
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() =
            MainFragment()
    }

    val databaseFaker: DatabaseFaker = DatabaseFaker()
    val networkFaker: NetworkFaker = NetworkFaker()
    private val myLocalDataSource: MyLocalDataSource = MyLocalDataSource(databaseFaker)
    private val myRemoteDataSource: MyRemoteDataSource = MyRemoteDataSource(networkFaker)

    val viewModel: MyViewModel by viewModels {
        MyViewModelFactory(
            MyRepository(myLocalDataSource, myRemoteDataSource),
            MyViewModelState()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textFieldObserver = Observer<String> { newMessage ->
            message.text = newMessage
        }

        viewModel.myViewModelState.textField.observe(this, textFieldObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        viewModel!!.callRepo()
    }
}