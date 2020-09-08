package com.zesthra.persona.ui.splashscreen.pinUI

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.zesthra.persona.R
import com.zesthra.persona.data.db.entities.User
import com.zesthra.persona.databinding.EnterPINFragmentBinding
import kotlinx.android.synthetic.main.enter_p_i_n_fragment.*
import kotlinx.android.synthetic.main.sign_up_fragment.*
import org.koin.android.ext.android.inject
import java.util.concurrent.Executor


class EnterPINFragment : Fragment() {

    private val args: EnterPINFragmentArgs by navArgs()
    lateinit var username : String
    var pin : Int = 0
    var isHWAvailable = false

    private val factory: EnterPINViewModelFactory by inject()

    private lateinit var viewModel: EnterPINViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : EnterPINFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.enter_p_i_n_fragment,
            container,
            false
        )
        viewModel = ViewModelProviders.of(this, factory).get(EnterPINViewModel::class.java)
        binding.viewmodel = viewModel
        username = args.username
        handleBiometricAuth()
        handleViewComponent(binding)
        return binding.root
    }

    private fun handleBiometricAuth() {
        val biometricManager= context?.let { BiometricManager.from(it) }
        if (biometricManager != null) {
            when (biometricManager.canAuthenticate()) {
                BiometricManager.BIOMETRIC_SUCCESS ->
                    isHWAvailable = true
                BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->
                    isHWAvailable = false
                BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE ->
                    isHWAvailable = false
                BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED ->
                    isHWAvailable = false
            }
        }
    }

    private fun authUser(executor: Executor) {
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(getString(R.string.auth_title))
//            .setSubtitle(getString(R.string.auth_subtitle))
            .setDescription(getString(R.string.auth_description))
            .setDeviceCredentialAllowed(true)
            .build()
        val biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    super.onAuthenticationSucceeded(result)
                    view?.findNavController()
                        ?.navigate(R.id.action_enterPINFragment_to_homeActivity)
                }
                override fun onAuthenticationError(
                    errorCode: Int, errString: CharSequence
                ) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(
                        context,
                        getString(R.string.error_msg_auth_error, errString),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(context,
                        getString(R.string.error_msg_auth_failed),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        biometricPrompt.authenticate(promptInfo)
    }
    private fun handleViewComponent(binding: EnterPINFragmentBinding) {
        if(isHWAvailable){
            binding.instantUnlockButton.visibility = View.VISIBLE
        }
        binding.greetings.text = getString(R.string.greeting_enter_PIN, username)
        binding.textinputlayoutPIN.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                when {
                    p0?.length!! < 1 -> {
                        textinputlayoutPIN.error = getString(R.string.err_pin_required)
                        textinputlayoutPIN.isErrorEnabled = true
                    }
                    p0.length > 4 -> {
                        textinputlayoutPIN.error = getString(R.string.err_pin_exceeded)
                        textinputlayoutPIN.isErrorEnabled = true
                    }
                    else -> {
                        pin = Integer.parseInt(p0.toString())
                        textinputlayoutPIN.isErrorEnabled = false
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })
        binding.instantUnlockButton.setOnClickListener { view: View ->
            val executor = ContextCompat.getMainExecutor(context)
            authUser(executor)
        }
        binding.btnNext.setOnClickListener { view: View ->
            viewModel.getListUser()?.observe(viewLifecycleOwner,
                { t: List<User?>? ->
                    if (t?.size!! > 0) {
                        if (pin != 0) {
                            if(pin == t[0]?.pincode && !binding.textinputlayoutPIN.isErrorEnabled){
                                view.findNavController()
                                    .navigate(R.id.action_enterPINFragment_to_homeActivity)
                            }else {
                                Toast.makeText(context, "Wrong PIN, Please try Again", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        Toast.makeText(context, "Error Getting User Data, Please Try Again", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}