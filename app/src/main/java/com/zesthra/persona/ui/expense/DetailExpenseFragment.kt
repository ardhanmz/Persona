package com.zesthra.persona.ui.expense

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zesthra.persona.R

class DetailExpenseFragment : Fragment() {

    companion object {
        fun newInstance() = DetailExpenseFragment()
    }

    private lateinit var viewModel: DetailExpenseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_expense_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailExpenseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}