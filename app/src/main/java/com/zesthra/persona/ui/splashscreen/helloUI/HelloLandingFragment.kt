package com.zesthra.persona.ui.splashscreen.helloUI

import android.app.LauncherActivity.ListItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.zesthra.persona.Persona
import com.zesthra.persona.R
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.databinding.FragmentHelloLandingBinding
import javax.inject.Inject


class HelloLandingFragment(): Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: HelloLandingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

        (activity?.application as Persona)
            .getPersonaComponent()
            ?.inject(this)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HelloLandingViewModel::class.java)
        val binding: FragmentHelloLandingBinding =  DataBindingUtil.inflate(inflater, R.layout.fragment_hello_landing, container, false)
        binding.viewmodel = viewModel
        binding.hellonext.setOnClickListener { view : View ->
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
        return binding.root;
    }




}