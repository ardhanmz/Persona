package com.zesthra.persona.ui.splashscreen.pinUI

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.zesthra.persona.R
import com.zesthra.persona.databinding.EnterPINFragmentBinding
import kotlinx.android.synthetic.main.activity_home.view.*

class EnterPINFragment : Fragment() {

    val args: EnterPINFragmentArgs by navArgs()
    lateinit var username : String
    companion object {
        fun newInstance() = EnterPINFragment()
    }

    private lateinit var viewModel: EnterPINViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : EnterPINFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.enter_p_i_n_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(EnterPINViewModel::class.java)
        binding.viewmodel = viewModel;
        username = args.username;
        binding.btnNext.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_enterPINFragment_to_homeActivity)
        }
        return binding.root
    }


}