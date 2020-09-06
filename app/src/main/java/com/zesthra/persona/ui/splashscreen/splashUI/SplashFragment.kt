package com.zesthra.persona.ui.splashscreen.splashUI

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.zesthra.persona.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SplashFragment : Fragment() {

    private val TIME_OUT:Long=3000 // 3 sec

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val handler = Handler()
        val view: View =  inflater.inflate(R.layout.fragment_splash, container, false)
        handler.postDelayed({
            view.findNavController().navigate(R.id.action_splashFragment_to_helloLandingFragment)
        }, TIME_OUT)
        return view
    }


}