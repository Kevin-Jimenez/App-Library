package com.example.applibrary.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.*
import com.example.applibrary.R
import com.example.applibrary.data.viewmodels.LoginViewModel
import com.example.applibrary.databinding.FragmentLoginBinding
import com.example.applibrary.isValidEmail
import com.example.applibrary.isValidPassword
import com.example.applibrary.ui.activities.HomeActivity
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModel()

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

        binding.loginButton.setOnClickListener {
            /*Validacion Login Email*/
            if(!binding.loginInputEmail.text.toString().isValidEmail()){
                binding.loginFragmentEmailLayout.error = getString(R.string.email_error)
            }else{
                binding.loginFragmentEmailLayout.error = null
            }
            /* FIn Validacion Login Email*/

            /*Validacion Login password */
            if(!binding.loginInputPassword.text.toString().isValidPassword()){
                binding.loginFragmentPasswordLayout.error = getString(R.string.contrasena_error)
            }else{
                binding.loginFragmentPasswordLayout.error = null
            }
            /* FIN Validacion Login password */

            /*Home Navigation*/
            if(binding.loginInputEmail.text.toString().isValidEmail() && binding.loginInputPassword.text.toString().isValidPassword()){
                binding.loginButton.isEnabled = false
                loginViewModel.login(binding.loginInputEmail.text.toString(), binding.loginInputPassword.text.toString())
            }
        }
        observeViewModels()
    }

    private fun observeViewModels(){
        loginViewModel.login.observe(viewLifecycleOwner, Observer {
            binding.loginButton.isEnabled = true
            if(it){
                val intent = Intent(requireContext(), HomeActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
        })
        loginViewModel.error.observe(viewLifecycleOwner, Observer {
            binding.loginButton.isEnabled = true
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        })
    }

}