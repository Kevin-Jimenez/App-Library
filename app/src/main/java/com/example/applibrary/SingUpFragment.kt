package com.example.applibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.applibrary.databinding.FragmentSingUpBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SingUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SingUpFragment : Fragment() {

    private var _binding: FragmentSingUpBinding? = null
    private val binding: FragmentSingUpBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSingUpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.loginFragmentSingup.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_singUpFragment_to_loginFragment)
        }
        /*Validar documento*/
        binding.singUpButton.setOnClickListener {
            if(!binding.singUpDocumento.text.toString().isValidDocument()){
                binding.documentoFragmentLayout.error = getString(R.string.documento_error)
            }else{
                binding.documentoFragmentLayout.error = null
            }
            /* fin Validar documento*/

            /*Validar nombre vacio*/
            if(!binding.singUpFullname.text.toString().isValidName()){
                binding.fullnameFragmentLayout.error = getString(R.string.name_error)
            }else{
                binding.fullnameFragmentLayout.error = null
            }

            /*Fin Validar nombre vacio*/

            /*Validar correo*/
            if(!binding.inputEmailSingUp.text.toString().isValidEmail()){
                binding.singupEmailLayout.error = getString(R.string.email_error)
            }else{
                binding.singupEmailLayout.error = null
            }
            /*Fin Validar correo*/

            /*Validar contraseña*/
            if (!binding.inputSingupPassword.text.toString().isValidPassword()){
                binding.singUpPasswordLayout.error = getString(R.string.contrasena_error)
            }else{
                binding.singUpPasswordLayout.error = null
            }
            /*Fin Validar contraseña*/
        }

    }




}