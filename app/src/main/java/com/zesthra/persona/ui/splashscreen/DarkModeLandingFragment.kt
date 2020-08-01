package com.zesthra.persona.ui.splashscreen

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.zesthra.persona.R
import com.zesthra.persona.databinding.DarkModeLandingFragmentBinding

class DarkModeLandingFragment : Fragment() {

    companion object {
        fun newInstance() = DarkModeLandingFragment()
    }

    private lateinit var viewModel: DarkModeLandingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : DarkModeLandingFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.dark_mode_landing_fragment, container, false);
        viewModel = ViewModelProviders.of(this).get(DarkModeLandingViewModel::class.java);
        binding.viewmodel = viewModel;
        binding.btnDark.setOnClickListener { view: View ->
            viewModel.selectDarkMode(view);
        }
        return binding.root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DarkModeLandingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}