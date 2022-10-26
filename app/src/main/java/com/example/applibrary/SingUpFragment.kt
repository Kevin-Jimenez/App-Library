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
    }




}