package com.example.applibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.applibrary.databinding.FragmentLoginBinding



/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.fragmentForgotPassword.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }
        binding.registroButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_loginFragment_to_singUpFragment)
        }
    }

}