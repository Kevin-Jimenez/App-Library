package com.example.applibrary.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applibrary.ui.adapters.LibroAdapter
import com.example.applibrary.data.models.LibroItemModel
import com.example.applibrary.R
import com.example.applibrary.data.models.ServiceItemModel
import com.example.applibrary.data.viewmodels.HomeViewModule
import com.example.applibrary.databinding.FragmentWritersBinding
import com.example.applibrary.interfaces.OnLibroClickListener
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [WritersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WritersFragment : Fragment() {

    private var _binding: FragmentWritersBinding? = null
    private val binding: FragmentWritersBinding get() = _binding!!
    private val args: WritersFragmentArgs by navArgs()
    private  lateinit var libroAdapter: LibroAdapter
    private lateinit var categories: MutableList<String>
    private val homeViewModel: HomeViewModule by sharedViewModel()

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
        homeViewModel.clear()
        libroAdapter = LibroAdapter(listOf())
        binding.homeFragmentRecycle.apply {
            adapter = libroAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        libroAdapter.listener = object : OnLibroClickListener{
            override fun onClick(item: LibroItemModel) {
                homeViewModel.selected(item)
                view?.findNavController()?.navigate(R.id.action_writersFragment_to_writtersDetailsFragment)
            }

        }

        if(args.search){
            homeViewModel.libros(null)
            binding.writtersFragmentSearchLayout.visibility = View.VISIBLE
            binding.writtersFragmentCategoriasLabel.visibility = View.GONE
            binding.writtersFragmentTitle.text = getString(R.string.writers_label)
            binding.writtersFragmentSubtitle.text = getString(R.string.writers_subtitle)

        }else{
            binding.writtersFragmentSearchLayout.visibility = View.GONE
            binding.writtersFragmentCategoriasLabel.visibility = View.VISIBLE
            binding.writtersFragmentTitle.text = args.name
            binding.writtersFragmentSubtitle.text = args.description
            homeViewModel.libros(args.name)
        }
        observeViewModels()
    }

    private fun observeViewModels(){
        homeViewModel.services.observe(viewLifecycleOwner, Observer {
            categories = it.map { it.title }.toMutableList()
            categories.add(0,"Todos")
            binding.writtersFragmentSearch.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, categories))
            binding.writtersFragmentSearch.setOnItemClickListener { parent, view, position, id ->
                if(position == 0){
                    homeViewModel.libros(null)
                }else{
                    val category = categories[position]
                    homeViewModel.libros(category)
                }
            }
        })
        homeViewModel.libros.observe(viewLifecycleOwner, Observer {
            libroAdapter.updateDataset(it)
        })
    }

}