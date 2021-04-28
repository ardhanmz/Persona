package com.zesthra.persona.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.zesthra.persona.R
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val viewModelFactory : HomeFragmentModelFactory by inject()
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.home_fragment, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        viewModel.getListUser()?.observe(viewLifecycleOwner, Observer { result: List<User?>? ->
            binding.txtUsernamename.text = result?.get(0)?.username
            binding.txtSumIncome.text = result?.get(0)?.income.toString()
        })
        viewModel.getListUser()?.observe(viewLifecycleOwner
        ) { t: List<User?>? ->
            binding.txtTopProfile.text = t?.get(0)?.username
        }
        setView(binding)
        return binding.root
    }

    private fun setView(binding: HomeFragmentBinding) {
        binding.fabHome.setOnClickListener { view : View ->
            val action = HomeFragmentDirections.actionNavigationHomeToAddNotes()
            view.findNavController().navigate(action)
        }

    }

    override fun onPause() {
        super.onPause()
        viewModel.username = binding.txtUsernamename.text as String;
        viewModel.income = binding.txtSumIncome.text as String
    }

}