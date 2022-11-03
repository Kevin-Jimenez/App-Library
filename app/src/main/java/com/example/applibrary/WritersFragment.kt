package com.example.applibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.applibrary.databinding.FragmentWritersBinding


/**
 * A simple [Fragment] subclass.
 * Use the [WritersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WritersFragment : Fragment() {

    private var _binding: FragmentWritersBinding? = null
    private val binding: FragmentWritersBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWritersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}