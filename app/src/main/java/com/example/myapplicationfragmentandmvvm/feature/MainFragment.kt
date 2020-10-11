package com.example.myapplicationfragmentandmvvm.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationfragmentandmvvm.R
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject
import androidx.lifecycle.ViewModelProviders
import com.example.myapplicationfragmentandmvvm.App.Companion.app
import com.example.myapplicationfragmentandmvvm.di.MainModule
import com.example.myapplicationfragmentandmvvm.feature.data.database.DatabaseFaker
import toothpick.Scope
import toothpick.Toothpick

class MainFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var databaseFaker: DatabaseFaker

    companion object {
        fun newInstance() =
            MainFragment()
    }

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val scope: Scope = Toothpick.openScope(this)

        Toothpick.inject(this, scope);

        databaseFaker

//        viewModel = ViewModelProviders.of(this, Toothpick.openScope(app)
//            .getInstance(ViewModelFactory::class.java))
//            .get(MyViewModel::class.java)

        viewModel = ViewModelProvider(this, viewModelFactory)[MyViewModel::class.java]

        val textFieldObserver = Observer<String> { newMessage ->
            message.text = newMessage
        }

        viewModel!!.myViewModelState.textField.observe(this, textFieldObserver)
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