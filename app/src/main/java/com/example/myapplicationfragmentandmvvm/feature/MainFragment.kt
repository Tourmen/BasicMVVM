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
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class MainFragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val factory: ViewModelFactory by instance()
    private lateinit var viewModel: MyViewModel

    companion object {
        fun newInstance() =
            MainFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]

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
        viewModel.callRepo()
    }
}