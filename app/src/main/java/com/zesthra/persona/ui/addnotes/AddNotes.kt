package com.zesthra.persona.ui.addnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.zesthra.persona.R
import com.zesthra.persona.databinding.ActivityAddNotesBinding
import org.koin.android.ext.android.inject

class AddNotes : AppCompatActivity() {
    private lateinit var viewModel: AddNotesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityAddNotesBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_notes)
        viewModel = ViewModelProvider(this).get(AddNotesViewModel::class.java)
        binding.viewmodel = viewModel
    }
}