package com.zesthra.persona.ui.splashscreen.pinUI

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zesthra.persona.R

class EnterPINFragment : Fragment() {

    companion object {
        fun newInstance() = EnterPINFragment()
    }

    private lateinit var viewModel: EnterPINViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.enter_p_i_n_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EnterPINViewModel::class.java)
        // TODO: Use the ViewModel
    }

}