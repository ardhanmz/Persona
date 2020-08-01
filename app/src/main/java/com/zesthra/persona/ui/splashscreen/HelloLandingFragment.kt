package com.zesthra.persona.ui.splashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.zesthra.persona.R
import com.zesthra.persona.databinding.FragmentHelloLandingBinding

class HelloLandingFragment : Fragment() {
    val application = activity?.application;
    companion object {
        fun newInstance() = HelloLandingFragment()
    }

    private lateinit var viewModel: HelloLandingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHelloLandingBinding =  DataBindingUtil.inflate(inflater, R.layout.fragment_hello_landing, container, false)
        viewModel = ViewModelProviders.of(this).get(HelloLandingViewModel::class.java)
        binding.viewmodel = viewModel
        binding.hellonext.setOnClickListener { view : View ->
            viewModel.toSelectMode(view);
        }
        return binding.root;
    }


}