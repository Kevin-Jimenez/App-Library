package com.example.applibrary.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.applibrary.R
import com.example.applibrary.databinding.FragmentForgotPasswordBinding
import com.example.applibrary.isValidEmail

//import kotlinx.android.synthetic.main.fragment_forgot_password.*


/**
 * A simple [Fragment] subclass.
 * Use the [ForgotPasswordFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ForgotPasswordFragment : Fragment() {

    private var _binding: FragmentForgotPasswordBinding?= null
    private val binding: FragmentForgotPasswordBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgotPasswordBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.loginButtonForgot.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_forgotPasswordFragment_to_loginFragment)
        }
        /*Validar Correo*/
        binding.forgotButton.setOnClickListener {
            if(!binding.inputForgot.text.toString().isValidEmail()){
                binding.emailForgotPassword.error = getString(R.string.email_error)
            }else{
                binding.emailForgotPassword.error = null
            }
        }
    }

}