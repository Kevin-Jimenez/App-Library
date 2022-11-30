package com.example.applibrary.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.applibrary.R
import com.example.applibrary.data.viewmodels.HomeViewModule
import com.example.applibrary.databinding.FragmentWrittersDetailsBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [WrittersDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WrittersDetailsFragment : Fragment() {

    private var _binding: FragmentWrittersDetailsBinding? = null
    private val binding: FragmentWrittersDetailsBinding get() = _binding!!
    private val homeViewModel: HomeViewModule by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWrittersDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        observeViewModels()
    }

    private fun observeViewModels(){
        homeViewModel.selected.observe(viewLifecycleOwner, Observer {
            binding.datailsImagen.setImageResource(it.image.toInt())
            binding.detailsName.text = it.name
            binding.detailsGenero.text = it.genero
            binding.detailsDesciption.text = it.descripcion
            binding.detailsTitleDesciption.text = "Resumen"
        })
    }

}