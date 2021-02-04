package com.zesthra.persona.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.zesthra.persona.R
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.databinding.HomeFragmentBinding
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val viewModelFactory : HomeFragmentModelFactory by inject()
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: HomeFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.home_fragment, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.getListUser()?.observe(viewLifecycleOwner
        ) { t: List<User?>? ->
            if(t?.size!! > 0){
                viewModel.income = t[0]!!.income
                viewModel.username = t[0]!!.username
            }else{
                viewModel.income = 0
                viewModel.username = "dummy"
            }
        }
        setView(binding)
        return binding.root
    }

    private fun setView(binding: HomeFragmentBinding) {
        binding.fabHome.setOnClickListener { view : View ->
            val action = HomeFragmentDirections.actionNavigationHomeToAddNotes()
            view.findNavController().navigate(action)
        }
        binding.txtUsernamename.text = viewModel.username
        binding.txtSumIncome.text = viewModel.income.toString()
    }


}