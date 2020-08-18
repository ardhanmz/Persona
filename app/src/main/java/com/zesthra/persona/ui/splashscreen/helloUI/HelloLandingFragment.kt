package com.zesthra.persona.ui.splashscreen.helloUI

import android.app.LauncherActivity.ListItem
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.zesthra.persona.R
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.data.preferences.PreferenceProvider
import com.zesthra.persona.databinding.FragmentHelloLandingBinding
import org.koin.android.ext.android.inject



class HelloLandingFragment(): Fragment() {


    private val factory : HelloLandingViewModelFactory by inject()
    private val sharedPref : PreferenceProvider by inject()
    lateinit var viewModel: HelloLandingViewModel





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this, factory).get(HelloLandingViewModel::class.java)
        val binding: FragmentHelloLandingBinding =  DataBindingUtil.inflate(inflater, R.layout.fragment_hello_landing, container, false)
        binding.viewmodel = viewModel
        checkUIMode()
        onClick(binding)
        return binding.root;
    }

    fun checkUIMode(){
        if(sharedPref.getUIMode()==true){
            AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    fun onClick(fragmentHelloLandingBinding: FragmentHelloLandingBinding){
        fragmentHelloLandingBinding.btnNext.setOnClickListener { view : View ->
            viewModel.getListUser()?.observe(viewLifecycleOwner,
                Observer<List<User?>?>{ t: List<User?>? ->
                    if(t?.size!! > 0){
                        Toast.makeText(context, "Anda Telah Terdaftar", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context, "User Kosong", Toast.LENGTH_SHORT).show()
                        view.findNavController().navigate(R.id.action_hello_to_darkmode)
                    }
                })

        }
    }




}