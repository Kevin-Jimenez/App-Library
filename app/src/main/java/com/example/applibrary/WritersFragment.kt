package com.example.applibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import com.example.applibrary.databinding.FragmentWritersBinding


/**
 * A simple [Fragment] subclass.
 * Use the [WritersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WritersFragment : Fragment() {

    private var _binding: FragmentWritersBinding? = null
    private val binding: FragmentWritersBinding get() = _binding!!
    private val args: WritersFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWritersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        if(args.search){
            binding.writtersFragmentSearchLayout.visibility = View.VISIBLE
            binding.writtersFragmentCategoriasLabel.visibility = View.GONE
            binding.writtersFragmentTitle.text = args.name
            binding.writtersFragmentSubtitle.text = args.description
        }else{
            binding.writtersFragmentSearchLayout.visibility = View.GONE
            binding.writtersFragmentCategoriasLabel.visibility = View.VISIBLE
            binding.writtersFragmentTitle.text = args.name
            binding.writtersFragmentSubtitle.text = args.description
        }
    }

}